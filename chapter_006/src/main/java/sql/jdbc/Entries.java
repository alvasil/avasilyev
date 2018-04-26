package sql.jdbc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Entries {
	private int n;
	private String url;
	private String username;
	private String password;

	@XmlElement(name = "entry")
	private List<Entry> entry = new ArrayList<>();

	public void add(Entry entry) {
		this.entry.add(entry);
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
