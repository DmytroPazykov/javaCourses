package algo.cycle;

import java.util.List;

import algo.utils.ExtendedNode;

public class CycleDFS {

    public void detectCycle(List<ExtendedNode> nodeList) {

        nodeList.forEach(extendedNode -> {
            if (!extendedNode.isVisited()) {
                dfs(extendedNode);
            }
        });
    }

    private void dfs(ExtendedNode extendedNode) {
        System.out.println("DFS on Nodes " + extendedNode);

        extendedNode.setBeingVisited(true);

        extendedNode
                .getChildren()
                .forEach(node -> {
                    System.out.println("Visiting the children of the Node " + node);

                    if (node.isBeingVisited()) {
                        System.out.println("Cycle cycle cycle!");
                    }
                    if (!node.isVisited()) {
                        System.out.println("Visiting node " + node + "recursively...");
                        node.setVisited(true);
                        dfs(node);
                    }
                });

        extendedNode.setBeingVisited(false);
        extendedNode.setVisited(true);
    }
}
