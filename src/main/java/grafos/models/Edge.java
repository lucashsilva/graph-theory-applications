package grafos.models;

public class Edge {
	private Country from;
	private Country to;
	private String label;

	public Edge(Country from, Country to, String label) {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Edge [label=" + label + "]";
	}
}
