package test.triee.trietree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import test.triee.trietree.tree.Trie;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AutoCompleteTest {
    @Test
    public void checkForKar() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions("kar"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(1, result.size());
    }

    @Test
    public void checkForHe() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions("he"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(2, result.size());
    }

    @Test
    public void checkForH() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions("h"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(4, result.size());
    }

    @Test
    public void checkForEmpty() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions(""); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(0, result.size());
    }

    @Test
    public void checkForNonExistent() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions("f"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(0, result.size());
    }

    @Test
    public void checkForSameWord() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions("help"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(1, result.size());
    }

    @Test
    public void checkForSameWordExtraLetter() throws Exception {
        Trie trie = setUpTrie();
        List<String> result = trie.getWordSuggestions("helpp"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
        assertEquals(0, result.size());
    }

    public Trie setUpTrie() {
        Trie trie = new Trie(); //create a new trie
        trie.insertWord("help");//add some words
        trie.insertWord("heat");
        trie.insertWord("has");
        trie.insertWord("bob");
        trie.insertWord("test");
        trie.insertWord("credit");
        trie.insertWord("karma");
        trie.insertWord("hit");
        return trie;
    }
}