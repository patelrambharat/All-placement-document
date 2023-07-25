// 2414. Length of the Longest Alphabetical Continuous Substring
// Medium
// 419
// 26
// Companies
// An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".

// For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
// Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.

 

// Example 1:

// Input: s = "abacaba"
// Output: 2
// Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
// "ab" is the longest continuous substring.
// Example 2:

// Input: s = "abcde"
// Output: 5
// Explanation: "abcde" is the longest continuous substring.

class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int cnt = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) - s.charAt(i-1) == 1){
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else{
                cnt = 1;
            }
        }
        return ans;
    }
}