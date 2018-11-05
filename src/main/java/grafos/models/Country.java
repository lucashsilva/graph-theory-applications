package grafos.models;

public class Country {
	private String id;

	public Country(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return this.id;
	}
}
