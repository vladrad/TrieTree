package test.triee.trietree.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vladi on 2/24/17.
 */

public class Node {
    public HashMap<Character, Node> neighbors = new HashMap<>(); //create a hashmap, it makes no sense to use a list

    public void insertWord(String word) { // Originaly in the programing problem I mentioned to have a hash map of hashmaps... Towards the end i switched to List<Node> this was wrong.
        HashMap<Character, Node> currentNeighbors = neighbors; // set the current neighbors and then go down the tree
        for (int length = 0; length < word.length(); length++) { // i loop through my words
            char letter = word.charAt(length); // i grab the character
            if (currentNeighbors.containsKey(letter)) { // contains the key
                currentNeighbors = currentNeighbors.get(letter).neighbors; //set the new node as currentNeighbors
            } else {
                Node newNode = new Node(); // no node found lets create one
                currentNeighbors.put(letter, newNode); // set the new nodes
                currentNeighbors = newNode.neighbors; // set so we dont overwrite previous same letter
            }
        }
    }

    public List<String> findAllWords(String word, String currentWord) { // I pass the string
        HashMap<Character, Node> currentNeighbors = neighbors; // set the current neighbors and then go down the tree
        for (int length = 0; length < word.length(); length++) { // grab the words
            char letter = word.charAt(length);
            currentWord += letter; // here i append the neighbors letters to formulate kind of a partial word, i pass this partial word to do a recursive search by appending other neighbors later
            if (currentNeighbors.containsKey(letter)) { // make sure there are no weird letters or anything we pass to hashmap
                currentNeighbors = currentNeighbors.get(letter).neighbors; // lets find the last node
            }
        }
        List<String> result = new ArrayList<>(); // this will hold our results

        if(Trie.get().dictionary.contains(currentWord)){
            result.add(currentWord);
        }
        getEndings(currentNeighbors, word, result); //call and search from last node down
        return result; // once we find it lets search from that last node recursive
    }

    public void getEndings(HashMap<Character, Node> currentNeighbors, String word, List<String> result) {
        for (Character nextPossibleChars : currentNeighbors.keySet()) {
            String currentPossibleWord = word + nextPossibleChars; // add the current word from the last note and now add the next possible chars
            if (Trie.get().dictionary.contains(currentPossibleWord)) { // grab the dictionary from the Trie and check if current word is in there
                result.add(currentPossibleWord); //add it
            }
            getEndings(currentNeighbors.get(nextPossibleChars).neighbors, currentPossibleWord, result); // set new neighbors and search recursively from here, pass the appended word on
        }
    }


}
