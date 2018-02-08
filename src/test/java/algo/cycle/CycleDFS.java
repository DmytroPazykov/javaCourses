package algo.cycle;

import java.util.List;

public class CycleDFS {

    public void detectCycle(List<NewNode> nodeList) {

        nodeList.forEach(newNode -> {
            if (!newNode.isVisited()) {
                dfs(newNode);
            }
        });
    }

    private void dfs(NewNode newNode) {
        System.out.println("DFS on Nodes " + newNode);

        newNode.setBeingVisited(true);

        newNode
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

        newNode.setBeingVisited(false);
        newNode.setVisited(true);
    }
}
