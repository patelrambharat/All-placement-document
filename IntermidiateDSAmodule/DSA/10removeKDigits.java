// 402. Remove K Digits
// Medium
// 7.9K
// 336
// Companies
// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

// Example 1:

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
// Example 2:

// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
// Example 3:

// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>st = new Stack<>();
        int i = 0;
        for(;i<num.length() && k> 0;){
            while(k> 0 && !st.isEmpty() && num.charAt(i) < st.peek()){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        while(!st.isEmpty() && k >0){
            st.pop();
            k--;
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        ans = ans + num.substring(i, num.length());
        i = 0;
        while(i< ans.length()){
            if(ans.charAt(i) == '0'){
                i++;
            }
            else{
                break;
            }
        }
        return ans.substring(i).length() == 0 ? "0" : ans.substring(i);
    }

}