package test.triee.trietree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import test.triee.trietree.tree.Trie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Trie trie = new Trie(); //create a new trie
        trie.insertWord("help");//add some words
        trie.insertWord("heat");
        trie.insertWord("has");
        trie.insertWord("bob");
        trie.insertWord("test");
        trie.insertWord("credit");
        trie.insertWord("karma");
        trie.insertWord("hit");
        List<String> result = trie.getWordSuggestions("kar"); // get auto complete
        System.out.print(Arrays.toString(result.toArray()));
    }
}
