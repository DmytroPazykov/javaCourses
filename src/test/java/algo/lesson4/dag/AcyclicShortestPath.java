package algo.lesson4.dag;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {

    public void shortestPath(List<ExtendedNode> nodeList, ExtendedNode startNode, ExtendedNode targetNode) {
        startNode.setDistance(0);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.makeTopologicalOrder(nodeList);

        Stack<ExtendedNode> stack = topologicalSort.getTopologicalOrder();


        for (ExtendedNode actualNode : stack) {
            for (Edge edge : actualNode.getAdjacencies()) {
                ExtendedNode u = edge.getStartNode();
                ExtendedNode v = edge.getTargetNode();

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

    public void showShortestPathTo(ExtendedNode targetNode){
        List<ExtendedNode> nodeList = new ArrayList<>();

        ExtendedNode actualNode = targetNode;
        nodeList.add(actualNode);

        while (actualNode.getPreviousNode() != null){
            actualNode = actualNode.getPreviousNode();
            nodeList.add(actualNode);
        }

        Collections.reverse(nodeList);
        System.out.println(nodeList);
    }
}