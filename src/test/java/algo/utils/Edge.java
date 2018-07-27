package algo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Edge {
    private double weight;
    private AdvancedNode startNode;
    private AdvancedNode targetNode;
}
