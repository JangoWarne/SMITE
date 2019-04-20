package uk.ac.glos.ct5057.assignment.s1609415.map;


import java.util.HashMap;

/**
 * This class stores MapEdges to connect nodes in a graph that can be searched to find a node
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class MapGraph {

    private HashMap<Character, GraphNode> nodes = new HashMap<>();

    public void addEdge(Character node1, Character node2, Integer edge) {
        // Add edge to node 1
        if (!nodes.containsKey(node1)) {
            nodes.put(node1, new GraphNode());
        }
        nodes.get(node1).addEdge(node2, edge);

        // Add edge to node 2
        if (!nodes.containsKey(node2)) {
            nodes.put(node2, new GraphNode());
        }
        nodes.get(node2).addEdge(node1, edge);
    }

    public HashMap<Character, Integer> getEdges(Character node) {
        // return edges for node
        if (nodes.containsKey(node)) {
            return nodes.get(node).getEdges();
        } else {
            return null;
        }
    }
}
