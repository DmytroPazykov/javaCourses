package algo.spaBellmanFord;

import algo.utils.AdvancedNode;
import algo.utils.Edge;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class BellmanFordAlgorithm {
    private List<AdvancedNode> nodeList;
    private List<Edge> edgeList;

    public void bellmanFord(AdvancedNode startNode) {
        startNode.setDistance(0);

        for (int i = 0; i < nodeList.size() - 1; i++) { // v-1
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
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge edge) {

        return edge.getStartNode().getDistance() + edge.getWeight() < edge.getTargetNode().getDistance();

    }

    public void shortestPathTo(AdvancedNode targetNode) {
        List<AdvancedNode> nodeList = new ArrayList<>();
        nodeList.add(targetNode);

        if (targetNode.getDistance() == Double.MAX_VALUE) {
            System.out.println("There is no path from the source to the target");
        }

        AdvancedNode actualNode = targetNode;

        while (actualNode.getPreviousNode() != null) {
            actualNode = actualNode.getPreviousNode();
            nodeList.add(actualNode);
        }

        Collections.reverse(nodeList);
        System.out.println(nodeList);
    }
}
