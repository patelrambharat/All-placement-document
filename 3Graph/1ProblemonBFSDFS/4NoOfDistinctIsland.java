// Number of Distinct Islands
// MediumAccuracy: 62.29%Submissions: 48K+Points: 4
// Done with this problem? Now use these skills to apply for a job in Job-A-Thon 21!

// Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

// Example 1:

// Input:
// grid[][] = {{1, 1, 0, 0, 0},
//             {1, 1, 0, 0, 0},
//             {0, 0, 0, 1, 1},
//             {0, 0, 0, 1, 1}}
// Output:
// 1



// Explanation:
// grid[][] = {{1, 1, 0, 0, 0}, 
//             {1, 1, 0, 0, 0}, 
//             {0, 0, 0, 1, 1}, 
//             {0, 0, 0, 1, 1}}
// Same colored islands are equal.
// We have 2 equal islands, so we 
// have only 1 distinct island.

// Example 2:

// Input:
// grid[][] = {{1, 1, 0, 1, 1},
//             {1, 0, 0, 0, 0},
//             {0, 0, 0, 0, 1},
//             {1, 1, 0, 1, 1}}
// Output:
// 3
// Explanation:
// grid[][] = {{1, 1, 0, 1, 1}, 
//             {1, 0, 0, 0, 0}, 
//             {0, 0, 0, 0, 1}, 
//             {1, 1, 0, 1, 1}}
// Same colored islands are equal.
// We have 4 islands, but 2 of them
// are equal, So we have 3 distinct islands.

// Approach:
// In any traversal technique, we have one starting node and it traverses all the nodes in the graph. We know about both the traversals, Breadth First Search (BFS) and Depth First Search (DFS). We can use any of the traversals to solve this problem, in our case we will be using BFS.

// The algorithm steps are as follows:

// The pairs of row and column (<row, column>) will represent the node numbers.
// For BFS traversal, we need a queue data structure and a visited array. Create a replica of the given array, i.e., create another array of the same size and call it a visited array. We can use the same matrix, but we will avoid alteration of the original data. 
// In the queue, insert a vertex (pair of <row, column>) and mark it as visited. 
// While BFS traversal, pop out an element from the queue and travel to all its neighbours. In a graph, we store the list of neighbours in an adjacency list but here we know the neighbours are in 8 directions. 
// We go in all 8 directions and check for unvisited land neighbours. To travel in 8 directions we will use nested loops, you can find the implementation details in the code. 
// BFS function call will make sure that it starts the BFS call from that unvisited land, and visits all the nodes that are on that island, and at the same time, it will also mark them as visited. 
// Since the nodes travelled in a traversal will be marked as visited, they will no further be called for any further BFS traversal. 
// Keep repeating these steps, for every land that you find unvisited, and visit the entire island. 
// Add a counter variable to count the number of times the BFS function is called, as in this way we can count the total number of starting nodes, which will give us the number of islands. 


// BFS Approach

import java.util.*;
class Solution {
    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
      vis[ro][co] = 1; 
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(ro, co)); 
      int n = grid.length; 
      int m = grid[0].length; 
      
      // until the queue becomes empty
      while(!q.isEmpty()) {
          int row = q.peek().first; 
          int col = q.peek().second; 
          q.remove(); 
          
          // traverse in the neighbours and mark them if its a land 
          for(int delrow = -1; delrow<=1;delrow++) {
              for(int delcol = -1; delcol <= 1; delcol++) {
                  int nrow = row + delrow; 
                  int ncol = col + delcol; 
          // check if neighbour row and column is valid, and is an unvisited land
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                  && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1; 
                      q.add(new Pair(nrow, ncol)); 
                  }
              }
          }
      }
  }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        int[][] vis = new int[n][m];
        int cnt = 0; 
        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < m ;col++) {
                // if not visited and is a land
                if(vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++; 
                    bfs(row, col, vis, grid); 
                }
            }
        }
        return cnt; 
    }
    
    public static void main(String[] args)
    {
        char[][] grid =  {
            {'0', '1', '1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0', '1', '0'}
        };
                
        Solution obj = new Solution();
        System.out.println(obj.numIslands(grid));
    }

}
class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}
Output: 2

// Time Complexity ~ O(N² + NxMx9), N² for the nested loops, and NxMx9 for the overall DFS of the matrix, that will happen throughout if all the cells are filled with 1.

// Space Complexity: O(N²) for visited array max queue space O(N²), If all are marked as 1 then the maximum queue space will be N².


// DFS Approach



// User function Template for Java

class Solution {
    
    public String toString(int r, int c){
        return Integer.toString(r) +" "+Integer.toString(c); 
    }
    public void dfs(int row, int col , ArrayList<String>vec,int grid[][] ,  int vis[][], int row0, int col0){
        vis[row][col] = 1;
        vec.add(toString(row - row0 , col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1, 0, +1 , 0};
        int delcol[] = {0, -1, 0 , +1};
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow<n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] ==1){
                dfs(nrow, ncol , vec, grid, vis, row0, col0);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][]  = new int[n][m];
        HashSet<ArrayList<String>>st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String>vec = new ArrayList<>();
                    dfs(i, j, vec, grid, vis, i, j);
                    st.add(vec);
                } 
            }
        }
        return st.size();
     }
}

