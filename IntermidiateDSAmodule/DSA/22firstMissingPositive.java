// // First Missing Positive
// 41. First Missing Positive
// Hard
// 14.5K
// 1.7K
// Companies
// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.
class Solution {
    public int firstMissingPositive(int[] nums) {
        //1. mark element which are out of range and manage presence of one
        boolean one  =false;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                one = true;
            }
            if(nums[i] < 1 || n < nums[i]){
                nums[i] = 1;   //because least positive integer
            }
        }
        if(one == false)  return 1;
        //2.map element with the index
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i]);   //index nikal liya
            nums[index -1] = -Math.abs(nums[index -1]);
        }
        //3.find out the missing integer
        for(int i=0;i<n;i++){
            //if element is positive that means index+1 is missing from the array
            if(nums[i] > 0)  return i+1;
        }
        return n+1;
    }
}