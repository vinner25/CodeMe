package blind75.graph;

import com.vinner.codeme.blind75.graph.CloneGraph;
import com.vinner.codeme.blind75.graph.Node;
import org.junit.Assert;
import org.junit.Test;

public class CloneGraphTest {

    CloneGraph cloneGraph = new CloneGraph();

    @Test
    public void shouldCloneGraph()
    {
        Node root = createSampleGraph();
        Node clonedGraph = cloneGraph.cloneGraph(root);
        Assert.assertNotNull(clonedGraph);
    }

    private Node createSampleGraph()
    {
        Node root = new Node(1);
        Node node2 = new Node(2);


        Node node3 = new Node(3);
        Node node4 = new Node(4);

        root.neighbors.add(node2);
        root.neighbors.add(node4);
        node2.neighbors.add(root);
        node2.neighbors.add(node3);


        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node3);
        node4.neighbors.add(root);

        return root;
    }
}
