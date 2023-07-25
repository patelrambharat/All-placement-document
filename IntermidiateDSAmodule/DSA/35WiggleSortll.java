// 324. Wiggle Sort II
// Medium
// 2.8K
// 929
// Companies
// Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

// You may assume the input array always has a valid answer.

 

// Example 1:

// Input: nums = [1,5,1,1,6,4]
// Output: [1,6,1,5,1,4]
// Explanation: [1,4,1,5,1,6] is also accepted.
// Example 2:

// Input: nums = [1,3,2,2,3,1]
// Output: [2,3,1,3,1,2]

class Solution {
    public void wiggleSort(int[] nums) {
      //step 1: sort the nums  
        Arrays.sort(nums);
      //step 2: make an extra array and manage equality on it 
        int n = nums.length;
        int res[] = new int[n];
      
        int i=1;
        int j = n-1;
        while(i<n){
            res[i] = nums[j];
            i += 2;
            j--;
        }
        i=0;
        while(i <n){
            res[i] = nums[j];
            i+=2;
            j--;
        }
        //step 3: fill input array from res
        for( i=0;i<nums.length;i++){
            nums[i] = res[i];
        }
    }
}