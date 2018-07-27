package algo.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(of = "name", includeFieldNames = false)
public class AdvancedNode implements Comparable<AdvancedNode>{

    private String name;
    private boolean visited;
    private double distance = Double.MAX_VALUE;
    private List<Edge> adjacencies;
    private AdvancedNode previousNode;

    public AdvancedNode(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
    }

    public void addChildren(Edge edge){
        this.adjacencies.add(edge);
    }

    @Override
    public int compareTo(AdvancedNode advancedNode) {
        return Double.compare(this.distance, advancedNode.getDistance());
    }
}
