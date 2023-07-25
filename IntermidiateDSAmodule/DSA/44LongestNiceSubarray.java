// 2401. Longest Nice Subarray
// Medium
// 1K
// 23
// Companies
// You are given an array nums consisting of positive integers.

// We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.

// Return the length of the longest nice subarray.

// A subarray is a contiguous part of an array.

// Note that subarrays of length 1 are always considered nice.

 

// Example 1:

// Input: nums = [1,3,8,48,10]
// Output: 3
// Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
// - 3 AND 8 = 0.
// - 3 AND 48 = 0.
// - 8 AND 48 = 0.
// It can be proven that no longer nice subarray can be obtained, so we return 3.
// Example 2:

// Input: nums = [3,1,5,11,13]
// Output: 1
// Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.

1. Brute force approach:
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 1;

        for(int i = 0; i < nums.length - maxLen; i++) {
            int currLen = 1;
            int subarrayOR = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if ((subarrayOR & nums[j]) == 0) {
                    subarrayOR |= nums[j];
                    currLen++;
                }

                else break;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n ^ 2), SC: O(1)
2. Optimized approach (using Sliding Window):
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0,
            maxLen = 1, subarrayOR = 0;

        for (int i = 0; i < nums.length; i++) {

            while ((subarrayOR & nums[i]) != 0) {
                subarrayOR ^= nums[start++];
            }

            subarrayOR |= nums[i];

            int currLen = i - start + 1;
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n), SC: O(1)