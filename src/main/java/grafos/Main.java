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
        
    }

    private static Graph<Country, Edge> createGraph() throws ImportException {
    	Graph<Country, Edge> graph = new SimpleWeightedGraph<Country, Edge>(Edge.class);
    	
    	VertexProvider<Country> vertexProvider = new GraphVertexProvider();
    	EdgeProvider<Country, Edge> edgeProvider = new GraphEdgeProvider();
   
    	CSVImporter<Country, Edge> importer = new CSVImporter<Country, Edge>(vertexProvider, edgeProvider);
    	
    	File csv = new File("./src/assets/edges_with_diff.csv");
    	
    	importer.setFormat(CSVFormat.EDGE_LIST);
    	importer.importGraph(graph, csv);
    	
        return graph;
    }
}
