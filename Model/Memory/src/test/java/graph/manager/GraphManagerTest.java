package graph.manager;

import com.artech.prototypev2.chuiko.manager.GraphManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GraphManagerTest {

    GraphManager manager;
    @Before
    public void setUp() throws Exception {
        manager = new GraphManager();
    }

    @Test
    public void testAddSplitsOfStringInGraph() throws Exception {
        String s = "1 1";
        manager.addSplitsOfStringInGraph(s, " ");
        assertTrue("1 - [1, 2];\n".equals(manager.getGraphToString()));
    }

    @Test
    public void testGetGraphToString() throws Exception {
        assertTrue("".equals(manager.getGraphToString()));
    }

    @Test
    public void testPrintGraphInFile() throws Exception {

    }

    @Test
    public void testAddFileInGraph() throws Exception {

    }

    @Test
    public void testAddAllFilesTxtInGraph() throws Exception {

    }
}