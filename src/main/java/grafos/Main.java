package grafos;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

import grafos.models.Country;
import grafos.models.Edge;
import grafos.providers.GraphEdgeProvider;
import grafos.providers.GraphVertexProvider;

import org.jgrapht.io.*;

import java.io.File;
import java.net.*;
import java.rmi.server.ExportException;

public final class Main {
    public static void main(String[] args) throws MalformedURLException, ExportException, org.jgrapht.io.ExportException, ImportException {
        Graph<Country, Edge> graph = createGraph();

        System.out.println(graph.toString());
    }

    private static Graph<Country, Edge> createGraph() throws ImportException {
    	Graph<Country, Edge> graph = new SimpleWeightedGraph<>(Edge.class);
    	
    	VertexProvider<Country> vertexProvider = new GraphVertexProvider();
    	EdgeProvider<Country, Edge> edgeProvider = new GraphEdgeProvider();
   
    	CSVImporter<Country, Edge> importer = new CSVImporter(vertexProvider, edgeProvider);
    	
    	File csv = new File("./src/assets/edges.csv");
    	
    	importer.importGraph(graph, csv);
  
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);

        return graph;
    }
}
