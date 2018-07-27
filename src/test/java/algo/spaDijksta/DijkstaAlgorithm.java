package algo.spaDijksta;

import algo.utils.AdvancedNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstaAlgorithm {

    public void computePath(AdvancedNode advancedNode) {

        advancedNode.setDistance(0);

        PriorityQueue<AdvancedNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(advancedNode);

        while (!priorityQueue.isEmpty()) {
            AdvancedNode actualNode = priorityQueue.poll();

            actualNode
                    .getAdjacencies()
                    .forEach(edge -> {
                        AdvancedNode node = edge.getTargetNode();

                        double newDistance = actualNode.getDistance() + edge.getWeight();

                        if (newDistance < node.getDistance()) {
                            priorityQueue.remove(node);
                            node.setDistance(newDistance);
                            node.setPreviousNode(actualNode);
                            priorityQueue.add(node);
                        }
                    });
        }
    }

    public List<AdvancedNode> getShortestPath(AdvancedNode targetNode) {
        List<AdvancedNode> shortestPathToTarget = new ArrayList<>();

        for (AdvancedNode node = targetNode; node != null; node = node.getPreviousNode()) {
            shortestPathToTarget.add(node);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }
}
