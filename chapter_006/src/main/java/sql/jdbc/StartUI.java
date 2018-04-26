package sql.jdbc;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.IOException;
import java.sql.SQLException;

public class StartUI {
	public static void main(String[] args) throws TransformerException, ParserConfigurationException, SAXException, IOException {
		Entries ent = new Entries();
		Database data = new Database();
		ent.setUrl("jdbc:postgresql://localhost:5432/postgres");
		ent.setUsername("postgres");
		ent.setPassword("admin");
		ent.setN(10);

		String xmlFirst = "C:\\projects\\avasilyev\\chapter_006\\src\\main\\java\\sql\\jdbc\\1.xml";
		String xmlSecond = "C:\\projects\\avasilyev\\chapter_006\\src\\main\\java\\sql\\jdbc\\2.xml";
		String xslt = "C:\\projects\\avasilyev\\chapter_006\\src\\main\\java\\sql\\jdbc\\xslt.xsl";

		try {
			data.createTableAndInsert(ent);
			data.convertToXml(ent, xmlFirst);
			data.convertXSLT(xslt, xmlFirst, xmlSecond);
			data.countFields(xmlSecond);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
