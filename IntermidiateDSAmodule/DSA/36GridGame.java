// 2017. Grid Game
// Medium
// 736
// 23
// Companies
// You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

// Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

// At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

// The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.

 

// Example 1:


// Input: grid = [[2,5,4],[1,5,1]]
// Output: 4
// Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
// The cells visited by the first robot are set to 0.
// The second robot will collect 0 + 0 + 4 + 0 = 4 points.
// Example 2:


// Input: grid = [[3,3,1],[8,5,2]]
// Output: 4
// Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
// The cells visited by the first robot are set to 0.
// The second robot will collect 0 + 3 + 1 + 0 = 4 points.

class Solution {
    public long gridGame(int[][] grid) {
  	int n = grid[0].length;
		long[] prefFromRow1 = new long[n];
		long[] suffixFromRow0 = new long[n];

		//making suffix sum array out of row0
		suffixFromRow0[n-1] = grid[0][n-1];
		for(int i = n-2;i>=0;i--) suffixFromRow0[i] = grid[0][i] + suffixFromRow0[i+1];

		//making prefix sum array out of row1
		prefFromRow1[0] = grid[1][0];
		for(int i = 1;i<n;i++) prefFromRow1[i] = grid[1][i] + prefFromRow1[i-1];

		//lets generate all the possible paths  for robot a
		//a path for robot a can be determined by the col "j" where robot a will be switching rows
		//for every j, we'll be having different paths (total n paths) for robot a
		long overall = Long.MAX_VALUE;
		for(int j = 0;j<n;j++){
			//if robot a switches its row on jth col, robot b is left with two choices.
			long choice1 = j+1<n ? suffixFromRow0[j+1] : 0; //collect all the people after we switched the row
			long choice2 = j-1>=0 ?prefFromRow1[j-1] : 0;//collect all the people before we switched the row
			long robotBbest = Math.max(choice1,choice2);
			//the min of all the bests
			overall = Math.min(overall,robotBbest);
		}
		return overall;
    }
}