// 1392. Longest Happy Prefix
// Hard
// 1.1K
// 34
// Companies
// A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

// Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

// Example 1:

// Input: s = "level"
// Output: "l"
// Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
// Example 2:

// Input: s = "ababab"
// Output: "abab"
// Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int [] lps = new int[n];
        int j=0; 
        for(int i=1;  i<n; i++){
            while(j>0 && s.charAt(i) != s.charAt(j)){
                j = lps[j-1]; 
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            lps[i] = j;
        }      
        return s.substring(0,lps[n-1]);
    }
}