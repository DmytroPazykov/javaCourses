package algo.cycle;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CycleTest {
    @Test
    public void test(){
        List<NewNode> testData = getTestData();

        CycleDFS cycleDFS = new CycleDFS();

        cycleDFS.detectCycle(testData);
    }

    private List<NewNode> getTestData() {
        NewNode node1 = new NewNode("node1");
        NewNode node2 = new NewNode("node2");
        NewNode node3 = new NewNode("node3");
        NewNode node4 = new NewNode("node4");
        NewNode node5 = new NewNode("node5");
        NewNode node6 = new NewNode("node6");

        node1.setChildren(node2);
        node1.setChildren(node3);
        node2.setChildren(node3);
        node4.setChildren(node5);
        node4.setChildren(node1);
        node5.setChildren(node6);
        node6.setChildren(node4);

        List<NewNode> nodes = new ArrayList<>();

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        return nodes;
    }
}
