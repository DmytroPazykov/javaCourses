package algo.dfs;

import algo.utils.Node;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DSTTest {

    @Test
    public void test() {
        List<Node> nodeList = getTestData();

        DFS dfs = new DFS();

        System.out.println("/_____________________________/");
        System.out.println("DFS recurred");
        dfs.dfs(nodeList, true);
    }

    @Test
    public void test2() {
        List<Node> nodeList = getTestData();

        DFS dfs = new DFS();
        System.out.println("/_____________________________/");
        System.out.println("DFS not recurred");
        dfs.dfs(nodeList, false);
    }

    private List<Node> getTestData() {
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Node node3 = new Node("node3");
        Node node4 = new Node("node4");
        Node node5 = new Node("node5");

        node1.setChildren(node2);
        node1.setChildren(node3);
        node3.setChildren(node4);
        node4.setChildren(node5);

        List<Node> nodes = new ArrayList<>();

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        return nodes;
    }
}
