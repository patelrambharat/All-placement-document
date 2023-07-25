// 76. Minimum Window Substring
// Hard
// 15.7K
// 649
// Companies
// Given two strings s and t of lengths m and n respectively, return the minimum window 
// substring
//  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tfreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tfreq.put(ch, tfreq.getOrDefault(ch, 0) + 1);
        }

        int start = 0, length = Integer.MAX_VALUE, matched = 0;
        String result = "";

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (tfreq.containsKey(ch)) {
                tfreq.put(ch, tfreq.get(ch) - 1);
                if (tfreq.get(ch) >= 0) {
                    matched += 1;
                }
            }

            while (matched == t.length()) {
                if (length > (end - start + 1)) {
                    length = (end - start + 1);
                    result = s.substring(start, end + 1);
                }
                char startChar = s.charAt(start);
                if (tfreq.containsKey(startChar)) {
                    if (tfreq.get(startChar) == 0) {
                        matched -= 1;
                    }
                    tfreq.put(startChar, tfreq.get(startChar) + 1);
                }
                start += 1;
            }
        }
        
        return result;
    }
}