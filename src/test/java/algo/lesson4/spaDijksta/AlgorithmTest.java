package algo.lesson4.spaDijksta;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;
import org.testng.annotations.Test;

public class AlgorithmTest {

    @Test
    public void test(){
        ExtendedNode nodeA = new ExtendedNode("A");
        ExtendedNode nodeB = new ExtendedNode("B");
        ExtendedNode nodeC = new ExtendedNode("C");

        nodeA.addChildren(new Edge(1, nodeA, nodeB));
        nodeA.addChildren(new Edge(1, nodeA, nodeC));
        nodeB.addChildren(new Edge(1, nodeB, nodeC));

        DijkstaAlgorithm algorithm = new DijkstaAlgorithm();

        algorithm.computePath(nodeA);

        System.out.println(algorithm.getShortestPath(nodeC));
    }

    @Test
    public void test1(){
        ExtendedNode node0 = new ExtendedNode("A");
        ExtendedNode node1 = new ExtendedNode("B");
        ExtendedNode node2 = new ExtendedNode("C");
        ExtendedNode node3 = new ExtendedNode("D");
        ExtendedNode node4 = new ExtendedNode("E");
        ExtendedNode node5 = new ExtendedNode("H");
        ExtendedNode node6 = new ExtendedNode("F");
        ExtendedNode node7 = new ExtendedNode("G");

        node0.addChildren(new Edge(5, node0, node1));
        node0.addChildren(new Edge(8, node0, node5));
        node0.addChildren(new Edge(9, node0, node4));

        node1.addChildren(new Edge(15, node1, node3));
        node1.addChildren(new Edge(12, node1, node2));
        node1.addChildren(new Edge(4, node1, node5));

        node2.addChildren(new Edge(3, node2, node3));
        node2.addChildren(new Edge(11, node2, node7));

        node3.addChildren(new Edge(9, node3, node7));

        node4.addChildren(new Edge(5, node4, node5));
        node4.addChildren(new Edge(4, node4, node6));
        node4.addChildren(new Edge(20, node4, node7));

        node5.addChildren(new Edge(7, node5, node2));
        node5.addChildren(new Edge(6, node5, node6));

        node6.addChildren(new Edge(1, node6, node2));
        node6.addChildren(new Edge(13, node6, node7));

        DijkstaAlgorithm algorithm = new DijkstaAlgorithm();

        algorithm.computePath(node0);

        System.out.println(algorithm.getShortestPath(node7));
    }
}
