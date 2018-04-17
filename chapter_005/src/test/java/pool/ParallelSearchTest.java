package pool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParallelSearchTest {
	@Test
	public void whenSearchFiles() throws InterruptedException {
		List<String> exts = new ArrayList<>();
		exts.add(".txt");

		ParallelSearch search = new ParallelSearch("e:\\JAVA\\", "test", exts);
		search.init();

		for (String e : search.result()) {
			System.out.println(e);
		}
	}
}
