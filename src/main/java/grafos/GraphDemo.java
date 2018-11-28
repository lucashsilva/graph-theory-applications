package grafos;

import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.server.ExportException;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.WeightedPseudograph;
import org.jgrapht.io.CSVFormat;
import org.jgrapht.io.CSVImporter;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.ImportException;
import org.jgrapht.io.VertexProvider;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import grafos.models.Country;
import grafos.models.Edge;
import grafos.providers.GraphEdgeProvider;
import grafos.providers.GraphVertexProvider;

public final class GraphDemo extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
	private JGraphXAdapter<Country, Edge> adapter;
	
    public static void main(String[] args) throws MalformedURLException, ExportException, org.jgrapht.io.ExportException, ImportException {
        GraphDemo applet = new GraphDemo();
        
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void init() {
    	try {
			ListenableGraph<Country, Edge> g = createGraph();
			
			adapter = new JGraphXAdapter(g);
			
			setPreferredSize(DEFAULT_SIZE);
	        mxGraphComponent component = new mxGraphComponent(adapter);
	        component.setConnectable(false);
	        component.getGraph().setAllowDanglingEdges(false);
	        getContentPane().add(component);
	        resize(DEFAULT_SIZE);
	        
	        mxCircleLayout layout = new mxCircleLayout(adapter);

	        // center the circle
	        int radius = 100;
	        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
	        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
	        layout.setRadius(radius);
	        layout.setMoveCircle(true);

	        layout.execute(adapter.getDefaultParent());
		} catch (ImportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static ListenableGraph<Country, Edge> createGraph() throws ImportException {
    	ListenableGraph<Country, Edge> graph = new DefaultListenableGraph(new WeightedPseudograph<Country, Edge>(Edge.class));
    	
    	VertexProvider<Country> vertexProvider = new GraphVertexProvider();
    	EdgeProvider<Country, Edge> edgeProvider = new GraphEdgeProvider();
   
    	CSVImporter<Country, Edge> importer = new CSVImporter<Country, Edge>(vertexProvider, edgeProvider);
    	
    	File csv = new File("./src/assets/adjacent_matrix_reduced.csv");
    	
    	importer.setFormat(CSVFormat.MATRIX);
    	importer.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_NODEID, true);
    	importer.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_EDGE_WEIGHTS, true);
    	
    	importer.importGraph(graph, csv);
    	
        return graph;
    }
}
