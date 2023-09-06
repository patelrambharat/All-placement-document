// Distance of Nearest Cell having 1
// Problem Statement: Given a binary grid of N*M. Find the distance of the nearest 1 in the grid for each cell.

// The distance is calculated as |i1  – i2| + |j1 – j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.

// 0's at (0,1), (1,2), (2,1) and (2,2) are at a distance of 1, 1, 1 and 2 from 1's at (0,0), (0,2), (2,0) and (1,1) respectively.

// Breadth First Search, BFS, is a traversal technique where we visit the nodes level-wise, i.e., it visits the same level nodes simultaneously, and then moves to the next level. 

// The intuition is that BFS will take a step from cells containing 1 and will reach out to all zeros that are at a distance of one. Apparently, we can say that the nearest 1 to the 0s is at a distance of one. Again if we take another step, we will reach the next set of zeros, for these zeros 1 is at a distance of two. If we continue the same, till we can go, we can reach all the 0’s possible. 

// We will choose the BFS algorithm as it moves step by step and we want all of them to traverse in a single step together so that we can have a minimum count with us.

// Approach:

// Initial configuration:

// Queue: Define a queue and insert the pair of starting nodes’ coordinates along with the steps (<coordinates, step>). For example, ((2, 1), 2) means cell (2, 1) is the source node and the nearest 1 can be found at a distance of 2 from the node.
// Visited array: an array initialized to 0 indicating unvisited nodes.  
// Distance matrix: stores the distance of the nearest cell having 1 for every particular cell.
// The algorithm steps are as follows:

// Push the pair of starting points and its steps (<coordinates, stept>) in the queue, and mark the cell as visited.
// Start the BFS traversal, pop out an element from the queue every time, and travel to all its unvisited neighbors having 0. 
// For every neighboring unvisited 0, we can mark the distance to be +1 of the current node distance and store it in the distance 2D array, and at the same time insert <{row, col}, steps+1> into the queue.
// Repeat the steps until the queue becomes empty and then return the distance matrix where we have stored the steps.

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length; 
	    int m = grid[0].length; 
	    // visited and distance matrix
	    int vis[][] = new int[n][m]; 
	    int dist[][] = new int[n][m]; 
	    // <coordinates, steps>
	    Queue<Node> q = new LinkedList<Node>();
	    // traverse the matrix
	    for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	        // start BFS if cell contains 1
	            if(grid[i][j] == 1) {
	                q.add(new Node(i, j, 0)); 
	                vis[i][j] = 1; 
	            }
	            else {
	                // mark unvisted 
	                vis[i][j] = 0; 
	            }
	        }
	    }
	    
	    
	    
	    int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
	    
	    
	    // n x m x 4 
	    // traverse till queue becomes empty
	    while(!q.isEmpty()) {
	        int row = q.peek().first; 
	        int col = q.peek().second; 
	        int steps = q.peek().third; 
	        q.remove(); 
	        dist[row][col] = steps; 
	        // for all 4 neighbours
	        for(int i = 0;i<4;i++) {
	            int nrow = row + delrow[i]; 
	            int ncol = col + delcol[i]; 
	            // check for valid unvisited cell
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
	            && vis[nrow][ncol] == 0)  {
	                    vis[nrow][ncol] = 1; 
    	            q.add(new Node(nrow, ncol, steps+1));  
	            } 
	            }
	        }
	    
	    // return distance matrix
	    return dist; 
    }