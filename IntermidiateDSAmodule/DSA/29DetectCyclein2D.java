// 1559. Detect Cycles in 2D Grid
// Medium
// 1K
// 24
// Companies
// Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.

// A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.

// Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

// Return true if any cycle of the same value exists in grid, otherwise, return false.

 

// Example 1:



// Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
// Output: true
// Explanation: There are two valid cycles shown in different colors in the image below:

// Example 2:



// Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
// Output: true
// Explanation: There is only one valid cycle highlighted in the image below:

// Example 3:



// Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
// Output: false
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid consists only of lowercase English letters.


class Solution {
    public boolean containsCycle(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;


        int[][] vis = new int[R][C];
        for(int i = 0; i < R; i ++) {
            
            for(int j = 0; j < C; j++) {
            
                boolean found = false;
                if(vis[i][j] == 0) {
                    int steps = 0;
                    found = dfs(i, j, i, j, grid, vis, steps);
                }
                if(found) return true;
            }
        }

        return false;
    }
    
    int[] delR = {0, 1, 0, -1};
    int[] delC = {1, 0, -1, 0};

    public boolean dfs(int r, int c, int destr, int destc, char[][] grid, int[][] vis, int steps) {
        int R = grid.length;
        int C = grid[0].length;

        // check range
        if(r >= R || r < 0 || c >= C || c < 0) return false;
        
        // check identical character
        if(grid[destr][destc] != grid[r][c]) return false;

        // check if reached a visited cell with valid steps
        if(vis[r][c] != 0) {
            if((steps+1) - vis[r][c] >= 4) return true;
            else return false;
        }        

        // mark visited with the current number of steps
        vis[r][c] = ++steps;        

        for(int i = 0; i < 4; i++) {
            int nbrR = r + delR[i];
            int nbrC = c + delC[i];

            boolean found = false;
            found = found || dfs(nbrR, nbrC, destr, destc, grid, vis, steps);
            if(found) return true;
        }

        return false;

    }    

}