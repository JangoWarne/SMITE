package uk.ac.glos.ct5057.assignment.s1609415.algorithms;


import uk.ac.glos.ct5057.assignment.s1609415.map.MapGraph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class searches for the shortest path between two points using Dijkstra's Algorithm
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class DijkstrasAlgorithm {

    public static ArrayList<Character> shortestRoute(MapGraph graph, Character startNode, Character endNode) {
        ArrayList<Character> searchedNodes = new ArrayList<>();
        HashMap<Character, ArrayList<Integer>> allDistances = new HashMap<>();
        ArrayList<Character> route;
        Character progressNode = startNode;

        if (progressNode != endNode) {
            while (progressNode != endNode) {

                searchedNodes.add(progressNode);    // add current node to already searched nodes
                addDistances(allDistances, searchedNodes, progressNode, graph.getEdges(progressNode));  // updates distances based on current node
                progressNode = nearestUncheckedNode(allDistances, searchedNodes);   // find the closest node

                if (progressNode == null) {
                    route = new ArrayList<>();
                    return route;
                }
            }

            route = retraceRoute(allDistances, searchedNodes, startNode, endNode);

        } else {
            route = new ArrayList<>();
            route.add(startNode);
        }
        return route;
    }

    private static void addDistances(HashMap<Character, ArrayList<Integer>> allDistances,
                                     ArrayList<Character> searchedNodes, Character progressNode, HashMap<Character, Integer> edges) {
        Integer progressMax;
        Integer nodeMax;
        ArrayList<Integer> progressDistances;
        ArrayList<Integer> nodeDistances;
        Integer newMax;

        if (allDistances.containsKey(progressNode)) {
            // if the node is already in the list
            progressDistances = allDistances.get( progressNode );
            progressMax = progressDistances.get( progressDistances.size()-1 );
        } else {
            progressMax = 0;
        }

        for (Character node: edges.keySet()) {
            if (!searchedNodes.contains(node)) {

                if (allDistances.containsKey(node)) {
                    // if the node is already in the list
                    nodeDistances = allDistances.get(node);
                    nodeMax = nodeDistances.get( nodeDistances.size()-1 );
                } else {
                    allDistances.put(node, new ArrayList<>());
                    nodeMax = Integer.MAX_VALUE;    // nodes default to infinity
                }

                // calculate distance value for node
                newMax = progressMax + edges.get(node);
                if (newMax > nodeMax) {
                    newMax = nodeMax;
                }

                // each checked node is a unique index for all node distance arrays
                // for new node or node that has skipped an update add missing indexes
                nodeDistances = allDistances.get(node);
                for (int i = nodeDistances.size(); i < searchedNodes.indexOf(progressNode); i++) {
                    nodeDistances.add(nodeMax);
                }
                allDistances.get(node).add( newMax );
            }
        }
    }

    private static Character nearestUncheckedNode(HashMap<Character, ArrayList<Integer>> allDistances,
                                                  ArrayList<Character> searchedNodes) {
        Integer nodeMax;
        ArrayList<Integer> nodeDistances;
        Integer shortest = null;
        Character nearest = null;
        boolean first = true;

        // find node with shortest distance that is not in the list of searched nodes
        for (Character node: allDistances.keySet()) {
            if (!searchedNodes.contains(node)) {
                nodeDistances = allDistances.get(node);
                nodeMax = nodeDistances.get( nodeDistances.size()-1 );

                if (first) {
                    shortest = nodeMax;
                    nearest = node;
                    first = false;
                } else if (shortest > nodeMax){
                    shortest = nodeMax;
                    nearest = node;
                }
            }
        }

        return nearest;
    }

    private static ArrayList<Character> retraceRoute(HashMap<Character, ArrayList<Integer>> allDistances,
                                                     ArrayList<Character> searchedNodes, Character startNode, Character endNode) {
        ArrayList<Character> route = new ArrayList<>();
        Character progressNode;
        ArrayList<Integer> nodeDistances;
        Integer currentLength;
        Integer nextLength;
        int nextNode = 0;

        progressNode = endNode;
        route.add(endNode);

        while (progressNode != startNode) {
            nodeDistances = allDistances.get(progressNode);

            if (nodeDistances.size() > 1) {
                // for current node find that first index that had the current distance
                for (int i = nodeDistances.size() - 1; i > 0; i--) {
                    currentLength = nodeDistances.get(i);
                    nextLength = nodeDistances.get(i - 1);

                    if (!nextLength.equals(currentLength)) {
                        nextNode = i;
                        break;
                    }

                    if (i == 1) {
                        nextNode = 0;
                        break;
                    }
                }
            } else {
                nextNode = 0;
            }

            // find the node who's index matches the first index position
            progressNode = searchedNodes.get(nextNode);
            route.add(progressNode);
        }

        return route;
    }
}
