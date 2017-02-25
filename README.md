#Trie Tree auto complete 
This is for a interview. The objective was to find words as you were typing, kind of like the prediction
mechanisam in google search.

#Method
I originally brute forced this method, by just loop through words and doing a startWith call. While this works
it is pretty slow. The next was organizing all the words into a hash maps with a starting letter. The
interviewer said  I was on the right track. He recommended to me a trie tree. It took me a while to remember how it works. During that time I kept thinking about a regular bfs tree (one that I made recently using a game im working on). After my phone call I went back and reviewed the problem. The person interviewing me was right, the right appraoch was to use hashmaps. 


#Inserting
Inserting is simple we have a node it holds a hashmap<char,node>. We take the word and loop through each letter
and insert it into the hashmap, if it does not exsist we create a new node and assign the letter as key. 
With each insertion of the letter and node I set the current hashmap as the next node. I initially made a mistake here by not setting it causing a bug where letters were overwriting my nodes. Also with each word addition to the node I add the words to a directory.

#Search
Searching through the tree, I take the letters of the word, I find the last node. I then start with this last node and search through recursivly by using the letters and appending each possible combination as we traverse down the tree. With each step we check if the current word we are using is in the directory, then we add it as a search result.

