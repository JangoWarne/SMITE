package uk.ac.glos.ct5057.assignment.s1609415.items;


import java.util.ArrayList;

/**
 * This class stores the information of a node in an Trie
 * It is a compressed trie node
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class TrieNode {
    private ArrayList<TrieNode> children;
    private ArrayList<Item> items;
    private String value;

    protected TrieNode(Item item, String value) {
        this.children = new ArrayList<>();
        this.items = new ArrayList<>();
        if(item != null) {
            this.items.add(item);
        }
        this.value = value;
    }

    protected void insertItem(Item newItem, String itemText, String combinedName) {
        combinedName = combinedName + getValue();

        if (combinedName.equals(itemText)) {
            // new item name matches node -> add to existing item
            addItemToArray(newItem);

        } else if (itemText.startsWith(combinedName)) {
            // new node name starts with combined name for this node -> check sub nodes
            addItemToArray(newItem); // node/sub-node contains item

            // get new item name with combined name for this node removed
            String trimmedName = itemText.substring( combinedName.length() );
            String nodeName;

            if (trimmedName.isEmpty()) {
                System.out.println( "TrieNode addItem error: trimmed name is empty after check comparing against " +
                        "current node, at node \"" + getValue() + "\" for item \"" + newItem.getName() + "\"" );
                return;
            }

            for (TrieNode node : getChildren()) {
                nodeName = node.getValue();

                if (nodeName.isEmpty()) {
                    System.out.println( "TrieNode addItem error: child node name is empty, " +
                            "at node \"" + getValue() + "\" for item \"" + newItem.getName() + "\"" );
                    return;

                } else if (trimmedName.charAt(0) < nodeName.charAt(0)) {
                    // first character of the trimmed new node name is
                    // before the first of the sub node name in the alphabet -> add new node before
                    addChildBefore(new TrieNode(newItem, trimmedName), node);
                    return;

                } else {
                    // check if both strings start with the same text
                    boolean match = true;
                    boolean usedTrimmed;
                    int position = 0;
                    int textLength;

                    if (trimmedName.length() < nodeName.length()) {
                        textLength = trimmedName.length();
                        usedTrimmed = true;
                    } else {
                        textLength = nodeName.length();
                        usedTrimmed = false;
                    }

                    // find first character where strings do not match
                    for (int i = 0; i < textLength; i++) {
                        match = ( trimmedName.charAt(i) == nodeName.charAt(i) );
                        position = i;

                        if (!match) {
                            break;
                        }
                    }

                    if (match) {
                        position += 1;
                    }

                    // if one or more characters match -> split child node
                    if (position != 0) {
                        if (match) {
                            if ((trimmedName.length() == nodeName.length())) {
                                // trimmed new node name matches sub node name -> add to sub node items
                                node.addItemToArray(newItem);
                                return;

                            } else if (usedTrimmed) {
                                // trimmed new node name is a subset of sub node name -> rename child node & add to new node using new item

                                // update string in child node
                                node.setValue( nodeName.substring(position) );

                                // move child to new sub node
                                TrieNode newNode = new TrieNode(newItem, trimmedName);
                                makeSubNode(node, newNode);
                                return;

                            } else {
                                // sub node name is a subset of trimmed new node name -> add to sub node
                                node.insertItem(newItem, itemText, combinedName);
                                return;
                            }

                        } else {
                            // trimmed node name and subNode name only start the same -> split child node & insert new item normally

                            // copy child node
                            TrieNode newNode = new TrieNode(null, nodeName.substring(0, position));
                            node.getItems().forEach(item -> newNode.addItemToArray(item));

                            // update string in child node
                            node.setValue( nodeName.substring(position) );

                            // move child to new sub node
                            makeSubNode(node, newNode);

                            // insert new item normally
                            newNode.insertItem(newItem, itemText, combinedName);
                            return;
                        }
                    }
                }
            }

            addChildAtEnd(new TrieNode(newItem, trimmedName));

        } else {
            System.out.println( "TrieNode addItem comparison error for item \"" + newItem.getName() + "\"" );
        }
    }

    private void addChildAtEnd(TrieNode newNode) {
        children.add(newNode);
    }

    private void addChildBefore(TrieNode newNode, TrieNode existingNode) {
        children.add(children.indexOf(existingNode), newNode);
    }

    protected ArrayList<Item> searchItems(String searchText, String combinedText) {
        combinedText = combinedText + getValue();
        ArrayList<Item> found = new ArrayList<>();

        if (combinedText.equals(searchText)) {
            // search matches node -> return item list
            return getItems();

        } else if (searchText.startsWith(combinedText)) {
            // search text starts with combined name for this node -> check sub nodes

            // get new item name with combined name for this node removed
            String trimmedText = searchText.substring( combinedText.length() );

            for (TrieNode node : getChildren()) {
                if (trimmedText.charAt(0) < node.getValue().charAt(0)) {
                    // first character of the trimmed search text is
                    // before the first of the sub node name in the alphabet -> return empty array
                    return new ArrayList<>();

                } else if (node.getValue().startsWith( trimmedText )) {
                    // trimmed search text is a subset of sub node name -> return child node items
                    return node.getItems();

                } else if (trimmedText.startsWith( node.getValue() )) {
                    // sub node name is a subset of trimmed search text -> search sub node
                    return node.searchItems(searchText, combinedText);
                }
            }
            // if no matches -> return empty array
            return new ArrayList<>();

        } else {
            //return empty array
            return new ArrayList<>();
        }
    }

    private void addItemToArray(Item newItem) {
        if (!items.contains(newItem)) {
            items.add(newItem);
        }
    }

    private ArrayList<Item> getItems() {
        return items;
    }

    private void setValue(String newString) {
        this.value = newString;
    }

    private String getValue() {
        return value;
    }

    private ArrayList<TrieNode> getChildren() {
        return children;
    }

    private void makeSubNode(TrieNode nodeToMove, TrieNode newNode) {
        newNode.addChildAtEnd(nodeToMove);
        children.set(children.indexOf(nodeToMove), newNode);
    }
}
