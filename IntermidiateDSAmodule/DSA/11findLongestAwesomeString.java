// 1542. Find Longest Awesome Substring
// Hard
// 705
// 11
// Companies
// You are given a string s. An awesome substring is a non-empty substring of s such that we can make any number of swaps in order to make it a palindrome.

// Return the length of the maximum length awesome substring of s.

 

// Example 1:

// Input: s = "3242415"
// Output: 5
// Explanation: "24241" is the longest awesome substring, we can form the palindrome "24142" with some swaps.
// Example 2:

// Input: s = "12345678"
// Output: 1
// Example 3:

// Input: s = "213123"
// Output: 6
// Explanation: "213123" is the longest awesome substring, we can form the palindrome "231132" with some swaps.
class Solution {
    public int longestAwesome(String s) {
        int res = 0, curr = 0, n = s.length(), seen[] = new int[1024];
        Arrays.fill(seen, n);
        seen[0] = -1;
        for(int i=0;i<n;i++){
            curr ^= 1 << (s.charAt(i) - '0');
            for(int a= 0;a<10;a++){
                res = Math.max(res, i - seen[curr ^ (1<< a)]);
            }
            res = Math.max(res, i - seen[curr]);
            seen[curr] = Math.min(seen[curr] , i);
        }
        return res;
    }
}