package algo.lesson4.dag;

import algo.lesson4.utils.ExtendedNode;
import algo.lesson4.utils.Edge;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    private Stack<ExtendedNode> stack;

    public TopologicalSort() {
        this.stack = new Stack<>();
    }

    public void makeTopologicalOrder(List<ExtendedNode> nodeList) {

        for (ExtendedNode node : nodeList) {
            if (!node.isVisited()) {
                dfs(node);
            }
        }
    }

    private void dfs(ExtendedNode node) {
        for (Edge edge : node.getAdjacencies()) {
            if (!edge.getTargetNode().isVisited()) {
                edge.getTargetNode().setVisited(true);
                dfs(edge.getTargetNode());
            }
        }

        this.stack.push(node);
    }

    public Stack<ExtendedNode> getTopologicalOrder() {
        Collections.reverse(this.stack);
        return this.stack;
    }
}
