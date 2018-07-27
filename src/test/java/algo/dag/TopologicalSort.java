package algo.dag;

import algo.utils.AdvancedNode;
import algo.utils.Edge;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    private Stack<AdvancedNode> stack;

    public TopologicalSort() {
        this.stack = new Stack<>();
    }

    public void makeTopologicalOrder(List<AdvancedNode> nodeList) {

        for (AdvancedNode node : nodeList) {
            if (!node.isVisited()) {
                dfs(node);
            }
        }
    }

    private void dfs(AdvancedNode node) {
        for (Edge edge : node.getAdjacencies()) {
            if (!edge.getTargetNode().isVisited()) {
                edge.getTargetNode().setVisited(true);
                dfs(edge.getTargetNode());
            }
        }

        this.stack.push(node);
    }

    public Stack<AdvancedNode> getTopologicalOrder() {
        Collections.reverse(this.stack);
        return this.stack;
    }
}
