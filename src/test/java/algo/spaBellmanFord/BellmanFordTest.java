package algo.spaBellmanFord;

import algo.utils.AdvancedNode;
import algo.utils.Edge;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordTest {

    @Test
    public void test() {

        List<AdvancedNode> nodeList = new ArrayList<>();

        nodeList.add(new AdvancedNode("A"));
        nodeList.add(new AdvancedNode("B"));
        nodeList.add(new AdvancedNode("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-1, nodeList.get(0), nodeList.get(2)));
        edgeList.add(new Edge(1, nodeList.get(1), nodeList.get(2)));

        BellmanFordAlgorithm algo = new BellmanFordAlgorithm(nodeList, edgeList);

        algo.bellmanFord(nodeList.get(0));

        algo.shortestPathTo(nodeList.get(2));
    }

    @Test
    public void testNegative() {

        List<AdvancedNode> nodeList = new ArrayList<>();

        nodeList.add(new AdvancedNode("A"));
        nodeList.add(new AdvancedNode("B"));
        nodeList.add(new AdvancedNode("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-1, nodeList.get(1), nodeList.get(2)));
        edgeList.add(new Edge(-11, nodeList.get(2), nodeList.get(1)));

        BellmanFordAlgorithm algo = new BellmanFordAlgorithm(nodeList, edgeList);

        algo.bellmanFord(nodeList.get(0));
    }

    @Test
    public void test1() {

        List<AdvancedNode> nodeList = new ArrayList<>();

        nodeList.add(new AdvancedNode("A"));
        nodeList.add(new AdvancedNode("B"));
        nodeList.add(new AdvancedNode("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-1, nodeList.get(1), nodeList.get(2)));
        edgeList.add(new Edge(1, nodeList.get(2), nodeList.get(1)));

        BellmanFordAlgorithm algo = new BellmanFordAlgorithm(nodeList, edgeList);

        algo.bellmanFord(nodeList.get(0));
    }

    @Test
    public void testNegativeExtended(){
        List<AdvancedNode> nodeList = new ArrayList<>();

        nodeList.add(new AdvancedNode("A"));
        nodeList.add(new AdvancedNode("B"));
        nodeList.add(new AdvancedNode("C"));
        nodeList.add(new AdvancedNode("D"));
        nodeList.add(new AdvancedNode("E"));
        nodeList.add(new AdvancedNode("F"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(-1, nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-2, nodeList.get(0), nodeList.get(3)));

        edgeList.add(new Edge(-6, nodeList.get(1), nodeList.get(2)));

        edgeList.add(new Edge(-1, nodeList.get(2), nodeList.get(4)));
        edgeList.add(new Edge(-2, nodeList.get(2), nodeList.get(5)));

        edgeList.add(new Edge(-4, nodeList.get(3), nodeList.get(1)));
        edgeList.add(new Edge(-3, nodeList.get(3), nodeList.get(4)));

        edgeList.add(new Edge(-1, nodeList.get(4), nodeList.get(5)));

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm(nodeList, edgeList);

        bellmanFordAlgorithm.bellmanFord(nodeList.get(0));
        bellmanFordAlgorithm.shortestPathTo(nodeList.get(5));
    }
}
