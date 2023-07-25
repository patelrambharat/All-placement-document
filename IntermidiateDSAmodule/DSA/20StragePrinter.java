// 664. Strange Printer
// Hard
// 1.1K
// 100
// Companies
// There is a strange printer with the following two special properties:

// The printer can only print a sequence of the same character each time.
// At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
// Given a string s, return the minimum number of turns the printer needed to print it.

 

// Example 1:

// Input: s = "aaabbb"
// Output: 2
// Explanation: Print "aaa" first and then print "bbb".
// Example 2:

// Input: s = "aba"
// Output: 2
// Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 

// Constraints:

// 1 <= s.length <= 100
// s consists of lowercase English letters.
class Solution {
    public int strangePrinter(String s) {
        StringBuilder sb = new StringBuilder();  //reduce the question to seqences of one time each leter as it the same problem :  aaabbbcccbbccaa -> abcbca
        int iter = 0;
        while (iter < s.length()){
            char last = s.charAt(iter);
            while (iter < s.length() && s.charAt(iter) == last) iter++;
            sb.append(last);
        }
        return strangePrinter(sb.toString(), new HashMap());
    }

    public int strangePrinter(String s, Map<String, Integer> mamo) {
        if (s.length() <= 2) return s.length();
        if (mamo.containsKey(s)) return mamo.get(s);

        char first = s.charAt(0);
        int bestScore = strangePrinter(s.substring(1) , mamo) +  1; // printing first saparated form next time the same leter appeare at cost 1
        for (int i = 1; i < s.length(); i++)  // printing first char at some previus turn with no added cost, but everything in between have been printed after first char
            if (s.charAt(i) == first) bestScore = Math.min(bestScore , strangePrinter(s.substring(1, i) , mamo) + strangePrinter(s.substring(i) , mamo));
             
        mamo.put(s, bestScore);
        return bestScore;
    }
}
    