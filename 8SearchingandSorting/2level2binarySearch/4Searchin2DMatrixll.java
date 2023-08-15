// 240. Search a 2D Matrix II
// Medium
// 11K
// 178
// Companies
// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
// Output: true

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j= matrix[0].length-1;
        while(i<matrix.length && j>=0){
            int cell = matrix[i][j];
            if(cell == target){
                return true;
            }
            else if(cell > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}


