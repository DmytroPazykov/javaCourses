package algo.dag;

import algo.utils.AdvancedNode;
import algo.utils.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {

    public void shortestPath(List<AdvancedNode> nodeList, AdvancedNode startNode, AdvancedNode targetNode) {
        startNode.setDistance(0);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.makeTopologicalOrder(nodeList);

        Stack<AdvancedNode> stack = topologicalSort.getTopologicalOrder();


        for (AdvancedNode actualNode : stack) {
            for (Edge edge : actualNode.getAdjacencies()) {
                AdvancedNode u = edge.getStartNode();
                AdvancedNode v = edge.getTargetNode();

                double newDistance = u.getDistance() + edge.getWeight();
                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPreviousNode(u);
                }
            }
        }

        if (targetNode.getDistance() == Double.MAX_VALUE) {
            System.out.println("No shortest path there...");
        } else {
            System.out.println("Target node shortest path : " + targetNode.getDistance());
        }
    }

    public void showShortestPathTo(AdvancedNode targetNode){
        List<AdvancedNode> nodeList = new ArrayList<>();

        AdvancedNode actualNode = targetNode;
        nodeList.add(actualNode);

        while (actualNode.getPreviousNode() != null){
            actualNode = actualNode.getPreviousNode();
            nodeList.add(actualNode);
        }

        Collections.reverse(nodeList);
        System.out.println(nodeList);
    }
}