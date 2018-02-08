package algo.dfs;

import algo.utils.Node;

import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Node> nodeStack = new Stack<>();

    public void dfs(List<Node> nodeList, boolean isRecurred) {
        nodeList.forEach(node -> {
            if (!node.isVisited()) {
                if (isRecurred) {
                    dfsRecursion(node);
                } else {
                    dfsWithStack(node);
                }
            }
        });
    }

    private void dfsRecursion(Node node) {
        System.out.println(node);

        node.getChildren().forEach(nodeChild -> {
            if (!nodeChild.isVisited()) {
                nodeChild.setVisited(true);
                dfsRecursion(nodeChild);
            }
        });
    }

    private void dfsWithStack(Node node) {
        this.nodeStack.add(node);
        node.setVisited(true);
        while (!nodeStack.isEmpty()) {
            Node actualNode = this.nodeStack.pop();
            System.out.println(actualNode);

            actualNode
                    .getChildren()
                    .forEach(nodeChild ->
                    {
                        nodeChild.setVisited(true);
                        this.nodeStack.push(nodeChild);
                    });
        }
    }
}
