package algo.topo;

import algo.utils.Node;

import java.util.Stack;

public class TopologicalOrder {
    private Stack<Node> nodeStack;

    public TopologicalOrder() {
        this.nodeStack = new Stack<>();
    }

    public void dfs(Node node) {
        node.setVisited(true);

        node.getChildren().forEach(nodeChild -> {
            if (!nodeChild.isVisited()) {
                dfs(nodeChild);
            }
        });

        nodeStack.push(node);
    }

    public Stack<Node> getNodeStack() {
        return nodeStack;
    }
}
