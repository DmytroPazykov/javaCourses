package algo.dag;

import algo.utils.AdvancedNode;
import algo.utils.Edge;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DAGTest {

    @Test
    public void test(){

        AdvancedNode node0 = new AdvancedNode("A");
        AdvancedNode node1 = new AdvancedNode("B");
        AdvancedNode node2 = new AdvancedNode("C");

        List<AdvancedNode> nodeList = new ArrayList<>();
        nodeList.add(node0);
        nodeList.add(node1);
        nodeList.add(node2);

        node0.addChildren(new Edge(1, node0, node1));
        node0.addChildren(new Edge(10, node0, node2));

        node1.addChildren(new Edge(1, node1, node2));

        AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
        acyclicShortestPath.shortestPath(nodeList, node0, node2);
        acyclicShortestPath.showShortestPathTo(node2);
    }
}
