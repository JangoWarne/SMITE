package uk.ac.glos.ct5057.assignment.s1609415.algorithms;

import uk.ac.glos.ct5057.assignment.s1609415.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class sorts an ArrayList of Items using Radix Sort
 * All methods are static
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class RadixSort {

    public enum SortValue{
        Name,
        Size,
        Price
    }


    public static ArrayList<Item> sort(ArrayList<Item> unsorted, SortValue sortValue, boolean reverse) {
        if(sortValue != SortValue.Name) {
            // if sorting by a number
            double largest = 0;
            double value;

            // find the exponent of the largest number
            for (Item item: unsorted) {
                if(sortValue == SortValue.Size) {
                    value = item.getSize();
                } else {
                    value = item.getPrice();
                }

                if(value > largest) {
                    largest = value;
                }
            }
            int exponent = toIntFloor( Math.log10(largest) );

            return sortDoubles(unsorted, sortValue, reverse, exponent);
        } else {
            // if sorting by a string
            return sortNames(unsorted, reverse, 0);
        }
    }


    private static ArrayList<Item> sortDoubles(ArrayList<Item> unsorted, SortValue sortValue, boolean reverse, int exponent) {
        if (unsorted.size() > 1) {
            // if there is more than one element to sort
            ArrayList<Item> sorted = new ArrayList<>();
            HashMap<Integer, ArrayList<Item>> splitList = new HashMap<>();
            boolean match = true;
            boolean first = true;
            double exp = 1/Math.pow(10, exponent);
            Double value;
            Double lastValue = 0.0;
            int digit;

            // split the ArrayList by digit at exponent onto a HashMap
            for (Item item: unsorted) {
                if(sortValue == SortValue.Size) {
                    value = item.getSize();
                } else {
                    value = item.getPrice();
                }
                digit = toIntFloor(value * exp) % 10;

                if (!splitList.containsKey(digit)) {
                    splitList.put(digit, new ArrayList<>());
                }
                splitList.get(digit).add(item);

                // check if all array elements match
                if(match) {
                    if(first) {
                        lastValue = value;
                        first = false;
                    }
                    match = lastValue.equals(value);
                }
            }

            // do not sort if all array elements match
            if(match) {
                return unsorted;
            }

            // recursively sort each of the separated arrays
            splitList.forEach((k,arrayList) -> splitList.put( k, sortDoubles(arrayList, sortValue, reverse, exponent-1) ));

            // combine sorted arrays by digit at exponent in requested direction
            if (!reverse) {
                for (int i = 0; i < 10; i++) {
                    if (splitList.containsKey(i)) {
                        sorted.addAll(splitList.get(i));
                    }
                }
            } else {
                for (int i = 9; i >= 0; i--) {
                    if (splitList.containsKey(i)) {
                        sorted.addAll(splitList.get(i));
                    }
                }
            }

            return sorted;
        } else {
            // do not sort if there is only one element
            return unsorted;
        }
    }


    private static ArrayList<Item> sortNames(ArrayList<Item> unsorted, boolean reverse, int position) {
        if (unsorted.size() > 1) {
            // if there is more than one element to sort
            ArrayList<Item> sorted = new ArrayList<>();
            HashMap<Character, ArrayList<Item>> splitList = new HashMap<>();
            boolean match = true;
            boolean first = true;
            String text;
            String lastText = " ";
            char character;

            // split the ArrayList by character at position onto a HashMap
            for (Item item: unsorted) {
                text = item.getName().toLowerCase();

                if(item.getName().length() > position) {
                    character = text.charAt(position);
                } else {
                    character = ' ';
                }

                if (!splitList.containsKey(character)) {
                    splitList.put(character, new ArrayList<>());
                }
                splitList.get(character).add(item);

                // check if all array elements match
                if(match) {
                    if(first) {
                        lastText = text;
                        first = false;
                    }
                    match = lastText.equals(text);
                }
            }

            // do not sort if all array elements match
            if(match) {
                return unsorted;
            }

            // recursively sort each of the separated arrays
            splitList.forEach((k,arrayList) -> splitList.put( k, sortNames(arrayList, reverse, position+1) ));

            // combine sorted arrays by character at position in requested direction
            if (!reverse) {
                for (Character letter: Arrays.asList(' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')) {
                    if (splitList.containsKey(letter)) {
                        sorted.addAll(splitList.get(letter));
                    }
                }
            } else {
                for (Character letter: Arrays.asList('z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p',
                        'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a',
                        '9', '8', '7', '6', '5', '4', '3', '2', '1', '0', ' ')) {
                    if (splitList.containsKey(letter)) {
                        sorted.addAll(splitList.get(letter));
                    }
                }
            }

            return sorted;
        } else {
            // do not sort if there is only one element
            return unsorted;
        }
    }

    private static int toIntFloor(double value) {
        return (int)Math.floor(value);
    }
}
