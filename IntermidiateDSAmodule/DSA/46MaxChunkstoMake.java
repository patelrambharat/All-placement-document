// 768. Max Chunks To Make Sorted II
// Hard
// 1.7K
// 49
// Companies
// You are given an integer array arr.

// We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

// Return the largest number of chunks we can make to sort the array.

 

// Example 1:

// Input: arr = [5,4,3,2,1]
// Output: 1
// Explanation:
// Splitting into two or more chunks will not return the required result.
// For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
// Example 2:

// Input: arr = [2,1,3,4,4]
// Output: 4
// Explanation:
// We can split into two chunks, such as [2, 1], [3, 4, 4].
// However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
class Solution {
    public int maxChunksToSorted(int[] arr) {
        //1. generate right min 
        
        int rmin[] = new int[arr.length+1];
        rmin[arr.length]  = Integer.MAX_VALUE;
        for(int i=arr.length - 1;i>=0;i--)
        {
            rmin[i]  = Math.min(rmin[i+1], arr[i]);
        }
        //2 . iterate on arrray and manage left max as well as count chuck

        int leftmax = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            leftmax = Math.max(leftmax, arr[i]);
            if(leftmax <= rmin[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
}