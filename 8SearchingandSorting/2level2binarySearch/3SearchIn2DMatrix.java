// 74. Search a 2D Matrix
// Medium
// 14.1K
// 374
// Companies
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int n = matrix.length;
       int m = matrix[0].length;
       int start = 0;
       int end = (n*m) -1;
       while(start <= end){
           int mid = start +  (end - start)/2;
            if(matrix[mid/m][mid%m] == target){
                return true;
            }
            if(matrix[mid/m][mid%m] < target){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
       } 
       return false;
    }
}


// better time complexity code
public class Solution {
    public boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // if not found, return false
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1; // binary search on rows
        int n = matrix[0].length;
        while (start <= end) { // binary search for 2D matrix
            int mid = start + (end - start) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                // apply binary search 1D on this row
                boolean ans = binarySearch(matrix[mid], target);
                return ans;
            }
            // if the element is less than the
            // starting element of that row then
            // search in upper rows, else search
            // in the lower rows
            if (target < matrix[mid][0]) {
                end = mid - 1;
            }
            if (target > matrix[mid][n - 1]) {
                start = mid + 1;
            }
        }
        return false;
    }
}


// time complexity :::::--> O(log(m) + log(n))

