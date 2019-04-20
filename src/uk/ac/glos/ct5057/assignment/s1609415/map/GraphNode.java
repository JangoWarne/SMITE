package uk.ac.glos.ct5057.assignment.s1609415.map;

import java.util.HashMap;

/**
 * This class store information about an edge between two nodes in a MapGraph
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class GraphNode {

    private HashMap<Character, Integer> edges = new HashMap<>();

    protected void addEdge(Character node, Integer length) {
        edges.put(node, length);
    }

    protected HashMap<Character, Integer> getEdges() {
        return edges;
    }
}
