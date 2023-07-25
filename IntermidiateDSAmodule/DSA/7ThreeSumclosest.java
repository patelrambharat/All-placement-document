// 16. 3Sum Closest
// Medium
// 9.5K
// 493
// Companies
// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Example 2:

// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

// Constraints:

// 3 <= nums.length <= 500
// -1000 <= nums[i] <= 1000
// -104 <= target <= 104
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int leastdiff = Integer.MAX_VALUE;
        int close = 0;
        if(nums != null && n>=3){
            Arrays.sort(nums);
            for(int i = 0;i<n-2;i++){
                for(int j = i+1, k = n-1;j<k;){  //set the two pointer
                int res = nums[i] + nums[j] + nums[k];
                if(res == target){
                    return res;
                }
                else{
                    int diff = Math.abs(target - res);
                    if(diff < leastdiff){
                        leastdiff = diff;
                        close = res;
                    }
                    if(res > target){
                        k--;  //drease the right pointer to try a small value
                    }
                    else{
                        j++;
                    }
                }

                }
            }
        }
        return close;
    }
}