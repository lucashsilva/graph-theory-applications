package grafos.providers;

import java.util.Map;

import org.jgrapht.io.Attribute;

import grafos.models.Country;

public class GraphVertexProvider implements org.jgrapht.io.VertexProvider<Country> {

	@Override
	public Country buildVertex(String id, Map<String, Attribute> attributes) {
		return new Country(id);
	}
}
