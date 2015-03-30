package graph.vertex;

import com.artech.prototypev2.chuiko.vertex.AbstractVertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AbstractVertexTest {

    protected class Vertex extends AbstractVertex {
        protected Vertex(String volue) {
            super(volue);
        }
    }

    Vertex vertex1, vertex2;

    @Before
    public void creatVertex() {
        vertex1 = new Vertex("vertex1");
        vertex2 = new Vertex("vertex2");
    }

    @Test
    public void testGetOutGoingEdges() throws Exception {
        assertTrue(vertex1.getOutGoingEdges().containsKey(vertex1) &&
                vertex1.getOutGoingEdges().keySet().size() == 1);

        vertex1.addEdgeInto(vertex2);
        assertTrue(vertex1.getOutGoingEdges().containsKey(vertex1) &&
                vertex1.getOutGoingEdges().containsKey(vertex2) &&
                vertex1.getOutGoingEdges().keySet().size() == 2);
    }

    @Test
    public void testAddEdgeInto() throws Exception {
        vertex1.addEdgeInto(vertex2);
        assertTrue(vertex1.getOutGoingEdges().get(vertex2) == 1);
        vertex1.addEdgeInto(vertex2);
        assertTrue(vertex1.getOutGoingEdges().get(vertex2) == 2);
    }

    @Test
    public void testIncSelfAssociation() throws Exception {
        assertTrue(vertex1.getOutGoingEdges().get(vertex1) == 1);
        vertex1.incSelfAssociation();
        assertTrue(vertex1.getOutGoingEdges().get(vertex1) == 2);
    }

    @Test
    public void testToString() throws Exception {
        assertTrue("vertex1".equals(vertex1.toString()));
    }

    @Test
    public void testCompareTo() throws Exception {

    }
}