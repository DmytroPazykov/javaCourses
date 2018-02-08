package algo.topo;

import algo.utils.Node;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoTest {

    @Test
    public void test() {
        TopologicalOrder order = new TopologicalOrder();
        List<Node> nodeList = getTestData();

        nodeList.forEach(node -> {
            if (!node.isVisited()){
                order.dfs(node);
            }
        });

        Stack<Node> nodeStack = order.getNodeStack();

        for (int i = 0; i< nodeList.size();i++){
            Node node = nodeStack.pop();
            System.out.println(node);
        }


        System.out.println("/_____________________________/");
    }

    private List<Node> getTestData() {
        Node node1 = new Node("node0");
        Node node2 = new Node("node1");
        Node node3 = new Node("node2");
        Node node4 = new Node("node3");
        Node node5 = new Node("node4");
        Node node6 = new Node("node5");

        node3.setChildren(node4);

        node4.setChildren(node2);

        node5.setChildren(node1);
        node5.setChildren(node2);

        node6.setChildren(node1);
        node6.setChildren(node3);

        List<Node> nodes = new ArrayList<>();

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);

        return nodes;
    }
}
