package uk.ac.glos.ct5057.assignment.s1609415.items;


import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

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

    public TrieNode(Item item, String value) {
        this.children = new ArrayList<>();
        this.items = new ArrayList<>();
        if(item != null) {
            this.items.add(item);
        }
        this.value = value;
    }

    public void sortItem(Item newItem, String itemText, String combinedText) {
        combinedText = combinedText + getValue();

        if (combinedText.equals(itemText)) {
            // new item name matches node -> add to existing item
            insertItem(newItem);

        } else if (itemText.startsWith(combinedText)) {
            for (TrieNode node : getChildren()) {
                if (itemText.startsWith( combinedText + node.getValue() )) {
                    // new node name starts with sub node name -> split child node

                    String postText = (combinedText + node.getValue()).replaceFirst(itemText, "");
                    String matchText = itemText.replaceFirst(combinedText,"");
                    matchText = matchText.replaceFirst(postText, "");

                    // update string in child node
                    node.setValue(postText);

                    // move child to new sub node
                    makeSubNode(node, newItem, matchText);
                    return;

                } else if ((combinedText + node.getValue()).startsWith( itemText )) {
                    // sub node name starts with new node name -> add to sub node
                    node.sortItem(newItem, itemText, combinedText);
                    return;
                }
            }
            addChild(new TrieNode(newItem, StringUtils.difference(itemText, combinedText)));

        } else {
            System.out.println( "TrieNode addItem comparison error for item \"" + newItem.getName() + "\"" );
        }
    }

    public void addChild(TrieNode newNode) {
        children.add(newNode);
    }

    public ArrayList<Item> searchItems(String searchText, String combinedText) {
        combinedText = combinedText + getValue();
        ArrayList<Item> found = new ArrayList<>();

        if (combinedText.startsWith(searchText)) {
            found = listItems();
        }

        return found;
    }

    public void insertItem(Item newItem) {
        items.add(newItem);
    }

    public ArrayList<Item> listItems() {
        ArrayList<Item> names = items;
        children.forEach(node -> names.addAll( node.listItems() ));

        return names;
    }

    public void setValue(String newString) {
        this.value = newString;
    }

    public String getValue() {
        return value;
    }

    public ArrayList<TrieNode> getChildren() {
        return children;
    }

    public void makeSubNode(TrieNode node, Item newItem, String matchText) {
        children.remove(node);
        TrieNode newNode = new TrieNode(newItem, matchText);
        newNode.addChild(node);
        children.add( newNode );
        return;
    }
}
