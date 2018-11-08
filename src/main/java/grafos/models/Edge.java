package grafos.models;

public class Edge {
	private Country from;
	private Country to;
	private String label;
	
	public Edge(Country from, Country to, String label) {
		super();
		System.out.println(from.getId() + " " + to.getId() + "\n");
		this.from = from;
		this.to = to;
		this.label = label;
	}
	
	public Country getFrom() {
		return from;
	}
	public void setFrom(Country from) {
		this.from = from;
	}
	public Country getTo() {
		return to;
	}
	public void setTo(Country to) {
		this.to = to;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
