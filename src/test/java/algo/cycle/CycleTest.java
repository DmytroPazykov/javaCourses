package algo.cycle;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import algo.utils.ExtendedNode;

public class CycleTest {
    @Test
    public void test(){
        List<ExtendedNode> testData = getTestData();

        CycleDFS cycleDFS = new CycleDFS();

        cycleDFS.detectCycle(testData);
    }

    private List<ExtendedNode> getTestData() {
        ExtendedNode node1 = new ExtendedNode("node1");
        ExtendedNode node2 = new ExtendedNode("node2");
        ExtendedNode node3 = new ExtendedNode("node3");
        ExtendedNode node4 = new ExtendedNode("node4");
        ExtendedNode node5 = new ExtendedNode("node5");
        ExtendedNode node6 = new ExtendedNode("node6");

        node1.setChildren(node2);
        node1.setChildren(node3);
        node2.setChildren(node3);
        node4.setChildren(node5);
        node4.setChildren(node1);
        node5.setChildren(node6);
        node6.setChildren(node4);

        List<ExtendedNode> nodes = new ArrayList<>();

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        return nodes;
    }
}
