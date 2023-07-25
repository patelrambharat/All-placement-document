// 2030. Smallest K-Length Subsequence With Occurrences of a Letter
// Hard
// 402
// 12
// Companies
// You are given a string s, an integer k, a letter letter, and an integer repetition.

// Return the lexicographically smallest subsequence of s of length k that has the letter letter appear at least repetition times. The test cases are generated so that the letter appears in s at least repetition times.

// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

// A string a is lexicographically smaller than a string b if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.

 

// Example 1:

// Input: s = "leet", k = 3, letter = "e", repetition = 1
// Output: "eet"
// Explanation: There are four subsequences of length 3 that have the letter 'e' appear at least 1 time:
// - "lee" (from "leet")
// - "let" (from "leet")
// - "let" (from "leet")
// - "eet" (from "leet")
// The lexicographically smallest subsequence among them is "eet".
// Example 2:

// example-2
// Input: s = "leetcode", k = 4, letter = "e", repetition = 2
// Output: "ecde"
// Explanation: "ecde" is the lexicographically smallest subsequence of length 4 that has the letter "e" appear at least 2 times.
// Example 3:

// Input: s = "bb", k = 2, letter = "b", repetition = 2
// Output: "bb"
// Explanation: "bb" is the only subsequence of length 2 that has the letter "b" appear at least 2 times.

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int sl= s.length();
        int letter_left=0;
        int letter_taken=0;
        for(int idx=0;idx<sl;idx++){
            if(s.charAt(idx)==letter) letter_left++;
        }
        //Stack<Character> st = new Stack<>();
        StringBuilder sb=new StringBuilder("z".repeat(k));
        int sbidx=-1;
        for(int idx=0;idx<sl;idx++){
            char c=s.charAt(idx);
            while(sbidx>=0 && sb.charAt(sbidx)>c && (sl-idx+sbidx+1>k)){
                if(sb.charAt(sbidx)==letter){
                    if(letter_left+letter_taken<=repetition) break;
                    letter_taken--;
                }
                sbidx--;
            }
            if(sbidx+1<k){
                if(c==letter){
                    sb.setCharAt(++sbidx,c);
                    letter_taken++;
                }
                else if(k-(sbidx+1)>repetition-letter_taken) {
                    //System.out.println(k);
                    sb.setCharAt(++sbidx,c);
                }
            }
            if(c==letter) letter_left--;
            //System.out.println("IDX = "+idx+" char = "+c+" letter_left = "+letter_left+" Taken = "+letter_taken );
            //System.out.println(sb.toString().substring(0,sbidx+1));
            //System.out.println(sbidx);
            
            //System.out.println("------------");
            
        }
    
        return sb.toString();
    }
}