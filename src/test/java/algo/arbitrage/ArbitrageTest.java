package algo.arbitrage;

import algo.utils.AdvancedNode;
import algo.utils.Edge;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArbitrageTest {

    @Test
    public void test() {
        List<AdvancedNode> nodeList = new ArrayList<>();

        nodeList.add(new AdvancedNode("USA"));
        nodeList.add(new AdvancedNode("EUR"));
        nodeList.add(new AdvancedNode("GBR"));
        nodeList.add(new AdvancedNode("CHF"));
        nodeList.add(new AdvancedNode("CAD"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(-1 * Math.log(0.741), nodeList.get(0), nodeList.get(1)));
        edgeList.add(new Edge(-1 * Math.log(0.657), nodeList.get(0), nodeList.get(2)));
        edgeList.add(new Edge(-1 * Math.log(1.061), nodeList.get(0), nodeList.get(3)));
        edgeList.add(new Edge(-1 * Math.log(1.005), nodeList.get(0), nodeList.get(4)));


        edgeList.add(new Edge(-1 * Math.log(1.349), nodeList.get(1), nodeList.get(0)));
        edgeList.add(new Edge(-1 * Math.log(0.888), nodeList.get(1), nodeList.get(2)));
        edgeList.add(new Edge(-1 * Math.log(1.433), nodeList.get(1), nodeList.get(3)));
        edgeList.add(new Edge(-1 * Math.log(1.366), nodeList.get(1), nodeList.get(4)));

        edgeList.add(new Edge(-1 * Math.log(1.521), nodeList.get(2), nodeList.get(0)));
        edgeList.add(new Edge(-1 * Math.log(1.126), nodeList.get(2), nodeList.get(1)));
        edgeList.add(new Edge(-1 * Math.log(1.614), nodeList.get(2), nodeList.get(3)));
        edgeList.add(new Edge(-1 * Math.log(1.538), nodeList.get(2), nodeList.get(4)));

        edgeList.add(new Edge(-1 * Math.log(0.942), nodeList.get(3), nodeList.get(0)));
        edgeList.add(new Edge(-1 * Math.log(0.698), nodeList.get(3), nodeList.get(1)));
        edgeList.add(new Edge(-1 * Math.log(0.619), nodeList.get(3), nodeList.get(2)));
        edgeList.add(new Edge(-1 * Math.log(0.953), nodeList.get(3), nodeList.get(4)));

        edgeList.add(new Edge(-1 * Math.log(0.995), nodeList.get(4), nodeList.get(0)));
        edgeList.add(new Edge(-1 * Math.log(0.732), nodeList.get(4), nodeList.get(1)));
        edgeList.add(new Edge(-1 * Math.log(0.650), nodeList.get(4), nodeList.get(2)));
        edgeList.add(new Edge(-1 * Math.log(1.049), nodeList.get(4), nodeList.get(3)));

        ArbitrageAlgorithm arbitrageAlgorithm = new ArbitrageAlgorithm(nodeList, edgeList);
        arbitrageAlgorithm.arbitrageAlgorithm(nodeList.get(0));

        arbitrageAlgorithm.printCycle();
    }
}
