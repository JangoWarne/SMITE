package uk.ac.glos.ct5057.assignment.s1609415.items;


import java.util.ArrayList;

/**
 * This class stores Items in a searchable trie that is sorts Items when they are added
 * It is a compressed suffix trie
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class SuffixTrie {
    private TrieNode trie = new TrieNode(null, "");

    public void addItem(Item item) {
        String sanitisedName = item.getName().toLowerCase();
        String sanitisedSize = String.valueOf(item.getSize());
        String sanitisedPrice = String.valueOf(item.getPrice());
        String suffixName;

        for (int i = 0; i < sanitisedName.length(); i++) {
            suffixName = sanitisedName.substring(i);
            trie.insertItem(item, suffixName, "");
        }

        for (int i = 0; i < sanitisedSize.length(); i++) {
            suffixName = sanitisedSize.substring(i);
            trie.insertItem(item, suffixName, "");
        }

        for (int i = 0; i < sanitisedPrice.length(); i++) {
            suffixName = sanitisedPrice.substring(i);
            trie.insertItem(item, suffixName, "");
        }
    }

    public ArrayList<Item> searchItems(String searchText) {
        String sanitisedText = searchText.toLowerCase();

        return trie.searchItems(sanitisedText, "");
    }
}
