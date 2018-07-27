package algo.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExtendedNode {

    private String name;
    private boolean isVisited = false;
    private boolean isBeingVisited = false;
    private List<ExtendedNode> children;


    public ExtendedNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void setChildren(ExtendedNode node) {
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
