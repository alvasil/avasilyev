package sql.jdbc;

import javax.xml.bind.annotation.XmlElement;

public class Entry {
	@XmlElement
	private int field;

	public Entry(int field) {
		this.field = field;
	}



}
