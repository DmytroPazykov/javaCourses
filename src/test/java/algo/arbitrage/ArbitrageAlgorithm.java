package algo.arbitrage;

import algo.utils.AdvancedNode;
import algo.utils.Edge;

import java.util.ArrayList;
import java.util.List;

public class ArbitrageAlgorithm {
    private List<AdvancedNode> nodeList;
    private List<Edge> edgeList;
    private List<AdvancedNode> cycleList;

    public ArbitrageAlgorithm(List<AdvancedNode> nodeList, List<Edge> edgeList) {
        this.nodeList = nodeList;
        this.edgeList = edgeList;
        this.cycleList = new ArrayList<>();
    }

    public void arbitrageAlgorithm(AdvancedNode startNode) {
        startNode.setDistance(0);

        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (Edge edge : edgeList) {

                AdvancedNode u = edge.getStartNode();
                AdvancedNode v = edge.getTargetNode();

                if (u.getDistance() == Double.MAX_VALUE) continue;

                double newDistance = u.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPreviousNode(u);
                }
            }
        }

        for (Edge edge : edgeList) {
            if (edge.getStartNode().getDistance() != Double.MAX_VALUE) {
                if (hasCycle(edge)) {
                    System.out.println("There has been a negative cycle detected...");

                    AdvancedNode node = edge.getStartNode();

                    while (!node.equals(edge.getTargetNode())) {
                        this.cycleList.add(node);
                        node = node.getPreviousNode();
                    }
                    this.cycleList.add(edge.getTargetNode());

                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge edge) {

        return edge.getStartNode().getDistance() + edge.getWeight() < edge.getTargetNode().getDistance();

    }

    public void printCycle() {
        if (this.cycleList != null) {
            System.out.println("Arbitrage opportunity detected");

            for (AdvancedNode node : this.cycleList) {
                System.out.println(node);
            }
        } else {
            System.out.println("No arbitrage opportunity detected");
        }
    }
}
