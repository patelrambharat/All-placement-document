// Detect cycle in an undirected graph

// Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency 
// list where adj[i] contains all the nodes ith node is having edge with.

// Example 1:

// Input:  
// V = 5, E = 5
// adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
// Output: 1



// DFS Approach

class Solution {
     private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> 
    adj) {
        vis[node] = 1; 
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj) == true) 
                    return true; 
            }
            // if adjacent node is visited and is not its own parent node
            else if(adjacentNode != parent) return true; 
        }
        return false; 
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       int vis[] = new int[V]; 
       for(int i = 0;i<V;i++) {
           if(vis[i] == 0) {
               if(dfs(i, -1, vis, adj) == true) return true; 
           }
       }
       return false; 
    }
}