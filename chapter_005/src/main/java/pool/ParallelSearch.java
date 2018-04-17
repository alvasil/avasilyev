package pool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@ThreadSafe
public class ParallelSearch {
	private final String root;
	private final String text;
	private final List<String> exts;
	volatile boolean finish;

	@GuardedBy("this")
	private final Queue<String> files = new LinkedList<>();

	@GuardedBy("this")
	private final List<String> paths = new ArrayList<>();


	public ParallelSearch(String root, String text, List<String> exts) {
		this.root = root;
		this.text = text;
		this.exts = exts;
	}

	/**
	 * Создает 2 нити.
	 * 1-ая - пробегает по файловой системе используя FileVisitor.
	 * <p>
	 * 2-ая - берет данные из Queue<String> files и считывает данные их них.
	 * Если в файле добавлен текст, то нужно добавить этот файл в список paths.
	 */
	public void init() throws InterruptedException {
		Thread search = new Thread() {
			@Override
			public void run() {
				try {
					Files.walkFileTree(Paths.get(root), new MyFileVisitor());
				} catch (IOException e) {
					e.printStackTrace();
				}
				finish = true;
			}
		};

		Thread read = new Thread() {
			@Override
			public synchronized void run() {
				while (!finish) {
					if (!files.isEmpty()) {
						for (String e : files) {
							if (e.contains(text)) {
								paths.add(e);
								files.remove(e);
							}
						}
					}
				}
			}
		};
		search.start();
		read.start();
		search.join();
		read.join();
	}

	synchronized List<String> result() {
		return this.paths;
	}

	/**
	 * Определяет поведение при обходе дерева.
	 * Если файл соответствует расширению List<String> exts, то путь этого файла добавляется в очередь files.
	 */
	class MyFileVisitor extends SimpleFileVisitor<Path> {
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			for (String exp : exts) {
				if (file.toString().endsWith(exp)) {
					synchronized (files) {
						files.offer(file.toString());
					}
				}
			}
			return FileVisitResult.CONTINUE;
		}
	}

}

