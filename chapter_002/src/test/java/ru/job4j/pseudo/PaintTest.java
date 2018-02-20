package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
	@Test
	public void whenDrawSquare() {
		// получаем ссылку на стандартный вывод в консоль.
		PrintStream stdout = System.out;
		// Создаем буфер для хранения вывода.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		//Заменяем стандартный вывод на вывод в пямять для тестирования.
		System.setOut(new PrintStream(out));
		// выполняем действия пишушиее в консоль.
		new Paint(new Square()).draw();
		// проверяем результат вычисления
		assertThat(
				new String(out.toByteArray()),
				is(
						new StringBuilder()
								.append("++++")
								.append("+  +")
								.append("+  +")
								.append("++++")
								.append(System.lineSeparator())
								.toString()
				)
		);
		// возвращаем обратно стандартный вывод в консоль.
		System.setOut(stdout);
	}
	@Test
	public void whenDrawTriangle() {
		PrintStream stdout = System.out;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		new Paint(new Triangle()).draw();
		assertThat(
				new String(out.toByteArray()),
				is(
						new StringBuilder()
								.append("  +  ")
								.append(" +++ ")
								.append("+++++")
								.append(System.lineSeparator())
								.toString()
				)
		);
		System.setOut(stdout);
	}
}
