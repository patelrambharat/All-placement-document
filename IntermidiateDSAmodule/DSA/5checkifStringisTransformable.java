// 1585. Check If String Is Transformable With Substring Sort Operations
// Hard
// 409
// 8
// Companies
// Given two strings s and t, transform string s into string t using the following operation any number of times:

// Choose a non-empty substring in s and sort it in place so the characters are in ascending order.
// For example, applying the operation on the underlined substring in "14234" results in "12344".
// Return true if it is possible to transform s into t. Otherwise, return false.

// A substring is a contiguous sequence of characters within a string.

 

// Example 1:

// Input: s = "84532", t = "34852"
// Output: true
// Explanation: You can transform s into t using the following sort operations:
// "84532" (from index 2 to 3) -> "84352"
// "84352" (from index 0 to 2) -> "34852"
// Example 2:

// Input: s = "34521", t = "23415"
// Output: true
// Explanation: You can transform s into t using the following sort operations:
// "34521" -> "23451"
// "23451" -> "23415"
// Example 3:

// Input: s = "12345", t = "12435"
// Output: false
class Solution {
    public boolean isTransformable(String s, String t) {
         List<Integer>[] sourceIndex = new ArrayList[10];
        for(int i = 0; i < 10; i++) sourceIndex[i] = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            sourceIndex[digit].add(i);
        }

        int[] pos = new int[10];
        for(int i = 0; i < t.length(); i++) {
            int digit = t.charAt(i) - '0';

            //Let's say digit is '1', and if target string has more 1's than source string then return false
            if(pos[digit] >= sourceIndex[digit].size()) return false;

            /**
                 All elements smaller than 'digit' should have already appeared in target string
                 Or it should be on the right side in source string

                 For e.g.
                 Source: 879
                 Target: 897

                 Now for 9 to move to left it has to be lower than 7,
                 Because only possible move is sorting elements in a window in an ascending order
            */
            for(int smallerDigit = 0; smallerDigit < digit; smallerDigit++) {
                if(pos[smallerDigit] < sourceIndex[smallerDigit].size() &&
                        sourceIndex[smallerDigit].get(pos[smallerDigit]) <
                                sourceIndex[digit].get(pos[digit])) return false;
            }
            pos[digit]++;
        }

        return true;
    }
}