package sql.jdbc;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Database {
	/**
	 * Создает таблицу данных, если она не существует.
	 * Вставляет в таблицу N записей со значениями 1..N.
	 * Если в таблице находились записи, то они удаляются перед вставкой.
	 *
	 * @param ent - инициализация
	 * @throws SQLException
	 */
	public void createTableAndInsert(Entries ent) throws SQLException {
		Connection conn = DriverManager.getConnection(ent.getUrl(), ent.getUsername(), ent.getPassword());
		Statement st = conn.createStatement();
		st.executeUpdate("CREATE TABLE if NOT EXISTS test (FIELD INT)");
		if (st.executeQuery("SELECT * from test") != null) {
			st.executeUpdate("DELETE FROM test");
		}
		PreparedStatement ins = conn.prepareStatement("INSERT INTO test(field) VALUES(?)");
		for (int i = 1; i <= ent.getN(); i++) {
			ins.setInt(1, i);
			ins.executeUpdate();
			ent.add(new Entry(i));
		}
		st.close();
		ins.close();
	}

	/**
	 * Конвертирует объект в xml
	 *
	 * @param ent  - инициализация
	 * @param path - путь к создаваемому файлу
	 */
	public void convertToXml(Entries ent, String path) {
		File file = new File(path);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(ent, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Преобразует первичый файл xml посредством xslt в новый файл xml
	 *
	 * @param pathXSLT - путь до xslt
	 * @param pathXml  - путь до первичного файла xml
	 * @param destXml  - путь до конечного файла xml
	 * @throws TransformerException
	 */
	public void convertXSLT(String pathXSLT, String pathXml, String destXml) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(pathXSLT));
		Transformer transformer = factory.newTransformer(xslt);
		Source text = new StreamSource(new File(pathXml));
		transformer.transform(text, new StreamResult(new File(destXml)));
	}

	/**
	 * Выводит арифметическую сумму значений всех атрибутов field в консоль.
	 *
	 * @param path - путь до требуемого файла xml
	 */
	public void countFields(String path) throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(path);

		NodeList list = doc.getElementsByTagName("entries");
		NodeList childNodes = list.item(0).getChildNodes();
		int sum = 0;
		for (int i = 0; i < childNodes.getLength(); i++) {
			if (childNodes.item(i).getAttributes() != null) {
				sum = sum + Integer.parseInt(childNodes.item(i).getAttributes().getNamedItem("field").getNodeValue());
			}
		}
		System.out.println(sum);
	}
}
