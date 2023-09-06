// 127. Word Ladder
// Hard
// 11.1K
// 1.8K
// Companies
// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words 
// beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, 
// return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

// Let’s first understand the Brute force approach to this problem. In Brute force, we just simply replace the startingWord character
//  by character and then check whether the transformed word is present in the wordList. If a word is present in the wordList, 
//  we try replacing another character in that word by again following similar steps as above, in order to attain the targetWord. 
//  We do this for all the characters in the startWord and then eventually return the minimum length of transforming the startWord 
//  to targetWord.

// Initial configuration:

// Queue: Define a queue data structure to store the BFS traversal.
// Hash set: Create a hash set to store the elements present in the word list to carry out the search and delete operations in O(1) time. 


// The intuition behind using the BFS traversal technique for this particular problem is that if we notice carefully,
//  we go on replacing the characters one by one which seems just like we’re moving level-wise in order to reach the destination i.e. 
//  the targetWord.



class Solution {
    class Pair{
        String first;
        int second;
        Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
         // Creating a queue ds of type {word,transitions to reach ‘word’}.
        Queue < Pair > q = new LinkedList < > ();
 
        // BFS traversal with pushing values in queue 
        // when after a transformation, a word is found in wordList.
        q.add(new Pair(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set < String > st = new HashSet < String > ();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        st.remove(startWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
      
            // we return the steps as soon as
            // the first occurence of targetWord is found.
            if (word.equals(targetWord) == true) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // check if it exists in the set and push it in the queue.
                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }

            }
        }
        // If there is no transformation sequence possible
        return 0;
    }
}