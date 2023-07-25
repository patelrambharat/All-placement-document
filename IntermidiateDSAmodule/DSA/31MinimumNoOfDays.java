// 1482. Minimum Number of Days to Make m Bouquets
// Medium
// 3K
// 77
// Companies
// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

// Example 1:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
// Example 2:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
// Output: -1
// Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
class Solution {
    public boolean ispossible(int arr[] , int mid, int bouquets, int k){
        int flowers = 0;
        int boqs = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > mid){
                flowers = 0;
            }
            else{
                flowers++;
                if(flowers == k){
                    boqs++;
                    flowers =0;

                }
                else{
                    continue;
                }
            }
            if(boqs >= bouquets){
                return true;
            }
            else
                return false;
        }
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        int ans = -1;
        int low = 0;
        int high = (int)Math.pow(10, 9);  //we can find the max and min values from the array
        while(low <= high){
            int mid  = low + (high - low)/2;
            if(ispossible(bloomDay, mid, m, k)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}