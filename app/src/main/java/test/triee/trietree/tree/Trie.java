package test.triee.trietree.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladi on 2/24/17.
 */

public class Trie {

    public Node root = new Node(); // so this is our root node ""
    public List<String> dictionary = new ArrayList<>();
    private static Trie instance;

    public Trie(){
        instance = this;
    }

    public static Trie get(){
        return instance; // used to get dictionary
    }

    public void insertWord(String word){
        dictionary.add(word);// im keeping a list of words we are adding
        root.insertWord(word);// now inserting word into tree
    }

    public List<String> getWordSuggestions(String auto){ //search for auto complete
        return root.findAllWords(auto,""); //find all words, start with a empty string
    }




}
