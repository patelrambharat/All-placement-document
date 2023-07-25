// 1926. Nearest Exit from Entrance in Maze
// Medium
// 1.9K
// 67
// Companies
// You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

// In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

// Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

 

// Example 1:


// Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
// Output: 1
// Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
// Initially, you are at the entrance cell [1,2].
// - You can reach [1,0] by moving 2 steps left.
// - You can reach [0,2] by moving 1 step up.
// It is impossible to reach [2,3] from the entrance.
// Thus, the nearest exit is [0,2], which is 1 step away.
// Example 2:


// Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
// Output: 2
// Explanation: There is 1 exit in this maze at [1,2].
// [1,0] does not count as an exit since it is the entrance cell.
// Initially, you are at the entrance cell [1,0].
// - You can reach [1,2] by moving 2 steps right.
// Thus, the nearest exit is [1,2], which is 2 steps away.


class Solution {
    class Pair{
        int first;
        int second;
        int step;
        Pair(int first, int second, int step){
            this.first = first;
            this.second = second;
            this.step = step;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int x = entrance[0];
        int y = entrance[1];
        int delrow[] = {1, -1, 0, 0};
        int delcol[] = {0, 0, 1, -1};
        int ans =0;
        Queue<Pair>q = new LinkedList<Pair>();
        q.add(new Pair(x, y, 0));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().step;
            maze[row][col] = '+';
            q.poll();
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && maze[nrow][ncol] == '.'){
                    maze[nrow][ncol] = '+';
                    q.add(new Pair(nrow, ncol, step+1));
                    if(nrow == 0 || ncol ==0 || nrow == n-1 || ncol == m-1){
                        ans = step +1;
                        return ans;
                    }
                }
            }
        }
        return -1;
    }
}