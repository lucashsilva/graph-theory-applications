package grafos.providers;

import java.util.Map;

import org.jgrapht.io.Attribute;
import org.jgrapht.io.EdgeProvider;

import grafos.models.Country;
import grafos.models.Edge;

public class GraphEdgeProvider implements EdgeProvider<Country, Edge> {

	@Override
	public Edge buildEdge(Country from, Country to, String label, Map<String, Attribute> attributes) {
		return new Edge(from, to, label);
	}

}
