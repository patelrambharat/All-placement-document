// 995. Minimum Number of K Consecutive Bit Flips
// Hard
// 1.1K
// 56
// Companies
// You are given a binary array nums and an integer k.

// A k-bit flip is choosing a subarray of length k from nums and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.

// Return the minimum number of k-bit flips required so that there is no 0 in the array. If it is not possible, return -1.

// A subarray is a contiguous part of an array.

 

// Example 1:

// Input: nums = [0,1,0], k = 1
// Output: 2
// Explanation: Flip nums[0], then flip nums[2].
// Example 2:

// Input: nums = [1,1,0], k = 2
// Output: -1
// Explanation: No matter how we flip subarrays of size 2, we cannot make the array become [1,1,1].
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        int flips = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == flips % 2){
                if(i > nums.length -k){
                    return -1;
                }
                res++;
                flips++;
                nums[i] -= 2;
            }
            if(i >= k-1 && nums[i- k+1] <0){
                flips--;
                nums[i-k+1] += 2;
            }
        }
        return res;
    }
}