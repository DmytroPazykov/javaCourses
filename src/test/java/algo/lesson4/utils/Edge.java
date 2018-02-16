package algo.lesson4.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Edge {
    private double weight;
    private ExtendedNode startNode;
    private ExtendedNode targetNode;
}
