package uk.ac.glos.ct5057.assignment.s1609415.algorithms;

import uk.ac.glos.ct5057.assignment.s1609415.items.Item;
import uk.ac.glos.ct5057.assignment.s1609415.map.MapGraph;

import java.util.ArrayList;

/**
 * This class is used to calculate the big O notation of the algorithms in this package
 * It outputs the time taken per number of inputs
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class BigOMeasurement {

    public static void main(String[] args) {

        System.out.println("Dijkstras Algorithm");
        bigODijkstras(100);
        bigODijkstras(300);
        bigODijkstras(1000);
        bigODijkstras(2000);
        bigODijkstras(3000);
        bigODijkstras(4000);
        bigODijkstras(5000);

        System.out.println("Radix Sort Algorithm");
        bigORadixSort(100000);
        bigORadixSort(300000);
        bigORadixSort(1000000);
        bigORadixSort(3000000);
        bigORadixSort(10000000);
    }

    private static void bigODijkstras(int inputs) {
        System.out.println("Inputs: " + inputs);

        ArrayList<Long> times = new ArrayList<>();

        for (int n = 0; n < 10; n++) {
            MapGraph graph = new MapGraph();
            ArrayList<Character> lastNodes = new ArrayList<>();
            ArrayList<Character> currentNodes = new ArrayList<>();
            Character startChar = Character.forDigit(1,10);
            Character char1;
            Character char2 = startChar;
            Character charLast;
            lastNodes.add( startChar );

            // Setup Data
            for (int i = 1; i < inputs + 1; i+=2) {
                char1 = (char) i;
                char2 = (char) (i+1);
                currentNodes.add(char1);
                currentNodes.add(char2);
                charLast = lastNodes.remove(lastNodes.size() - 1);

                graph.addEdge(charLast, char1, (int)(Math.random() * 30));
                graph.addEdge(charLast, char2, (int)(Math.random() * 30));

                if (lastNodes.isEmpty()) {
                    lastNodes.addAll( currentNodes );
                    currentNodes.clear();
                }
            }

            // Start time
            long start = System.currentTimeMillis();

            // run test
            DijkstrasAlgorithm.shortestRoute(graph, startChar, char2);

            // End time
            long end = System.currentTimeMillis();
            times.add(end - start);
        }

        long sum = 0;
        for (Long time : times) {
            sum += time;
        }
        long millis = sum / times.size();

        System.out.println("Iterations: " + times);
        System.out.println("Time Taken: " + millis + "ms");
        System.out.println();
    }

    private static void bigORadixSort(int inputs) {
        System.out.println("Inputs: " + inputs);

        ArrayList<Long> times = new ArrayList<>();

        for (int n = 0; n < 10; n++) {
            ArrayList<Item> unsorted = new ArrayList<>();
            Item item;
            double price;

            // Setup Data
            for (int i = 1; i < inputs + 1; i++) {
                price = Math.random();
                item = new Item("Test", 1.0, price, Item.Location.East);
                unsorted.add(item);
            }

            // Start time
            long start = System.currentTimeMillis();

            // Run test
            RadixSort.sort(unsorted, RadixSort.SortValue.Size, false);

            // End time
            long end = System.currentTimeMillis();
            times.add(end - start);
        }

        long sum = 0;
        for (Long time : times) {
            sum += time;
        }
        long millis = sum / times.size();

        System.out.println("Iterations: " + times);
        System.out.println("Time Taken: " + millis + "ms");
        System.out.println();
    }
}
