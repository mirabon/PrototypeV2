package graph.graph;

import com.artech.prototypev2.chuiko.graph.AbstractGraph;
import com.artech.prototypev2.chuiko.vertex.AbstractVertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AbstractGraphTest {

    private class Graph extends AbstractGraph {
    }
    Graph graph;
    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        graph.addVertex("vertex1");
    }

    @Test
    public void testGetVertices() throws Exception {
        assertTrue(graph.getVertices().size() == 1);
        graph.addVertex("vertex1");
        assertTrue(graph.getVertices().size() == 1);
        graph.addVertex("vertex2");
        assertTrue(graph.getVertices().size() == 2);
    }

    @Test
    public void testGetVertex() throws Exception {
        assertTrue(graph.getVertex("vertex1") instanceof AbstractVertex &&
                "vertex1".equals(graph.getVertex("vertex1").toString()));
        graph.addVertex("vertex2");
        assertTrue(graph.getVertex("vertex1") instanceof AbstractVertex &&
                "vertex2".equals(graph.getVertex("vertex2").toString()));
    }

    @Test
    public void testAddVertex() throws Exception {
        assertTrue(graph.getVertices().size() == 1);
        graph.addVertex("vertex2");
        assertTrue((graph.getVertices().size() == 2) &&
                "vertex2".equals(graph.getVertex("vertex2").toString()));
    }

    @Test
    public void testAddEdge() throws Exception {
        graph.addVertex("vertex2");
        graph.addEdge("VerTex1", "VerteX2");
        assertTrue(graph.getVertex("VERTex1").getOutGoingEdges().containsKey(graph.getVertex("vertex2")));
    }

    @Test
    public void testToString() throws Exception {
        assertTrue("vertex1".equals(graph.getVertex("VerteX1").toString()));
    }
}