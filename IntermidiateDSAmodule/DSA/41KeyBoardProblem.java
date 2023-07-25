// Possible Words From Phone Digits
// MediumAccuracy: 52.79%Submissions: 51K+Points: 4
// Share your Interview, Campus or Work Experience to win GFG Swag Kits and much more!

// Given a keypad as shown in the diagram, and an N digit number which is represented by array a[ ], the task is to list all words which are possible by pressing these numbers.


// Example 1:

// Input: N = 3, a[] = {2, 3, 4}
// Output:
// adg adh adi aeg aeh aei afg afh afi 
// bdg bdh bdi beg beh bei bfg bfh bfi 
// cdg cdh cdi ceg ceh cei cfg cfh cfi 
// Explanation: When we press 2,3,4 then 
// adg, adh, adi, ... cfi are the list of 
// possible words.

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to find a list of all words possible by pressing given numbers.
    public List<String> possibleWords(int[] a, int N) {
        List<String> ans = new ArrayList<>();
        if (N == 0) {
            return ans;
        }
        String output = "";
        int index = 0;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(a, output, index, ans, mapping, N);
        return ans;
    }

    private void solve(int[] a, String output, int index, List<String> ans, String[] mapping, int N) {
        // base case
        if (index >= N) {
            ans.add(output);
            return;
        }
        int number = a[index];
        String value = mapping[number];

        for (int i = 0; i < value.length(); i++) {
            output += value.charAt(i);
            solve(a, output, index + 1, ans, mapping, N);
            output = output.substring(0, output.length() - 1);
        }
    }
}
