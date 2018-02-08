package algo.cycle;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewNode {

    private String name;
    private boolean isVisited = false;
    private boolean isBeingVisited = false;
    private List<NewNode> children;


    public NewNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void setChildren(NewNode node) {
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
