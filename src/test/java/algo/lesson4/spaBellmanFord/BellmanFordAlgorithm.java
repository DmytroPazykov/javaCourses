package algo.lesson4.spaBellmanFord;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class BellmanFordAlgorithm {
    private List<ExtendedNode> nodeList;
    private List<Edge> edgeList;

    public void bellmanFord(ExtendedNode startNode) {
        startNode.setDistance(0);

        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (Edge edge : edgeList) {
                ExtendedNode u = edge.getStartNode();
                ExtendedNode v = edge.getTargetNode();

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

    public void shortestPathTo(ExtendedNode targetNode) {
        List<ExtendedNode> nodeList = new ArrayList<>();
        nodeList.add(targetNode);

        if (targetNode.getDistance() == Double.MAX_VALUE) {
            System.out.println("There is no path from the source to the target");
        }

        ExtendedNode actualNode = targetNode;

        while (actualNode.getPreviousNode() != null) {
            actualNode = actualNode.getPreviousNode();
            nodeList.add(actualNode);
        }

        Collections.reverse(nodeList);
        System.out.println(nodeList);
    }
}
