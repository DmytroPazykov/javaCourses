package algo.lesson4.spaDijksta;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstaAlgorithm {

    public void computePath(ExtendedNode extendedNode) {

        extendedNode.setDistance(0);

        PriorityQueue<ExtendedNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(extendedNode);

        while (!priorityQueue.isEmpty()) {
            ExtendedNode actualNode = priorityQueue.poll();

            actualNode
                    .getAdjacencies()
                    .forEach(edge -> {
                        ExtendedNode node = edge.getTargetNode();

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

    public List<ExtendedNode> getShortestPath(ExtendedNode targetNode) {
        List<ExtendedNode> shortestPathToTarget = new ArrayList<>();

        for (ExtendedNode node = targetNode; node != null; node = node.getPreviousNode()) {
            shortestPathToTarget.add(node);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }
}
