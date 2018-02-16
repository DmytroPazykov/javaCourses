package algo.lesson4.spaBellmanFord;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordTest {

    @Test
    public void test() {

        List<ExtendedNode> nodeList = new ArrayList<>();

        nodeList.add(new ExtendedNode("A"));
        nodeList.add(new ExtendedNode("B"));
        nodeList.add(new ExtendedNode("C"));

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

        List<ExtendedNode> nodeList = new ArrayList<>();

        nodeList.add(new ExtendedNode("A"));
        nodeList.add(new ExtendedNode("B"));
        nodeList.add(new ExtendedNode("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-1, nodeList.get(1), nodeList.get(2)));
        edgeList.add(new Edge(-11, nodeList.get(2), nodeList.get(1)));

        BellmanFordAlgorithm algo = new BellmanFordAlgorithm(nodeList, edgeList);

        algo.bellmanFord(nodeList.get(0));
    }

    @Test
    public void test1() {

        List<ExtendedNode> nodeList = new ArrayList<>();

        nodeList.add(new ExtendedNode("A"));
        nodeList.add(new ExtendedNode("B"));
        nodeList.add(new ExtendedNode("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-1, nodeList.get(1), nodeList.get(2)));
        edgeList.add(new Edge(1, nodeList.get(2), nodeList.get(1)));

        BellmanFordAlgorithm algo = new BellmanFordAlgorithm(nodeList, edgeList);

        algo.bellmanFord(nodeList.get(0));
    }

    @Test
    public void testNegativeExtended(){
        List<ExtendedNode> nodeList = new ArrayList<>();

        nodeList.add(new ExtendedNode("A"));
        nodeList.add(new ExtendedNode("B"));
        nodeList.add(new ExtendedNode("C"));
        nodeList.add(new ExtendedNode("D"));
        nodeList.add(new ExtendedNode("E"));
        nodeList.add(new ExtendedNode("F"));

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
