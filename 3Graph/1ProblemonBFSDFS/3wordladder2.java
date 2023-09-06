// G-30 : Word Ladder-II
// Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.

// In this problem statement, we need to keep the following conditions in mind:

// A word can only consist of lowercase characters.
// Only one letter can be changed in each transformation.
// Each transformed word must exist in the wordList including the targetWord.
// startWord may or may not be part of the wordList.
// Return an empty list if there is no such transformation sequence.
// Note: Please watch the previous video of this series before moving on to this particular problem as this is just an extension of the problem Word Ladder-I that is being discussed previously. The approach used for this problem would be similar to the approach used in that question.

// Examples:

// Example 1:
// Input:
// startWord = "der", targetWord = "dfs",
// wordList = {"des","der","dfr","dgt","dfs"}
// Output:
// [ [ “der”, “dfr”, “dfs” ], [ “der”, “des”, “dfs”] ]
// Explanation: 
// The length of the smallest transformation sequence here is 3.
// Following are the only two shortest ways to get to the targetWord from the startWord :
// "der" -> ( replace ‘r’ by ‘s’ ) -> "des" -> ( replace ‘e’ by ‘f’ ) -> "dfs".
// "der" -> ( replace ‘e’ by ‘f’ ) -> "dfr" -> ( replace ‘r’ by ‘s’ ) -> "dfs".


// Approach:
// This problem uses the BFS traversal technique for finding out all the shortest possible transformation sequences by exploring all possible ways in which we can reach the targetWord.

// Initial configuration:

// Queue: Define a queue data structure to store the level-wise formed sequences. The queue will be storing a List of strings, which will be representing the path till now. The last word in the list will be the last converted word. 
// Hash set: Create a hash set to store the elements present in the word list to carry out the search and delete operations in O(1) time. 
// Vector: Define a 1D vector ‘usedOnLevel’ to store the words which are currently being used for transformation on a particular level and a 2D vector ‘ans’ for storing all the shortest sequences of transformation.





import java.util.List;

public class Solution {
    class comp implements Comparator < ArrayList < String >> {

    public int compare(ArrayList < String > a, ArrayList < String > b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++)
            x += a.get(i);
        for (int i = 0; i < b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

    public static List<List< String >> shortestTransitionPaths(String startWord, String , List< String > targetWord) {
        // Write your code here.
          Set < String > st = new HashSet < String > ();
        int len = wordList.size;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue < ArrayList < String >> q = new LinkedList < > ();
        ArrayList < String > ls = new ArrayList < > ();
        ls.add(startWord);
        q.add(ls);
        ArrayList < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(startWord);
        int level = 0;

        // A vector to store the resultant transformation sequence.
        ArrayList < ArrayList < String >> ans = new ArrayList < > ();
        int cnt = 0;

        // BFS traversal with pushing the new formed sequence in queue 
        // when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {
            cnt++;
            ArrayList < String > vec = q.peek();
            q.remove();

             // Now, erase all words that have been
             // used in the previous levels to transform
             if (vec.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // store the answers if the end word matches with targetWord.
            if (word.equals(targetWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will 
                        // remove from everywhere 
                        ArrayList < String > temp = new ArrayList < > (vec);
                        q.add(temp);
                        // mark as visited on the level 
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;

    }
}