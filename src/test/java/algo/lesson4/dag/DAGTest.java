package algo.lesson4.dag;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DAGTest {

    @Test
    public void test(){

        ExtendedNode node0 = new ExtendedNode("A");
        ExtendedNode node1 = new ExtendedNode("B");
        ExtendedNode node2 = new ExtendedNode("C");

        List<ExtendedNode> nodeList = new ArrayList<>();
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
