// Depth First Search (DFS)
// Problem Statement: Given an undirected graph, return a vector of all nodes by traversing the graph using depth-first search (DFS).

// Pre-req: Recursion, Graph Representation


// Approach:
// DFS is a traversal technique which involves the idea of recursion and backtracking. DFS goes in-depth, i.e., traverses all nodes by going ahead, and when there are no further nodes to traverse in the current path, then it backtracks on the same path and traverses other unvisited nodes. 

// In DFS, we start with a node ‘v’, mark it as visited and store it in the solution vector. It is unexplored as its adjacent nodes are not visited.
// We run through all the adjacent nodes, and call the recursive dfs function to explore the node ‘v’ which has not been visited previously. This leads to the exploration of another node ‘u’ which is its adjacent node and is not visited. 
// The adjacency list stores the list of neighbours for any node. Pick the neighbour list of node ‘v’ and run a for loop on the list of neighbours (say nodes ‘u’ and ‘w’ are in the list). We go in-depth with each node. When node ‘u’ is explored completely then it backtracks and explores node ‘w’.
// This traversal terminates when all the nodes are completely explored. 


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public static void dfs(int node, boolean vis[] , ArrayList<ArrayList<Integer>>adj, ArrayList<Integer>ans){
        vis[node] = true;
        ans.add(node);
        //getting neighbour node
        for(Integer it : adj.get(node)){            //neighbour node pe jao 
            if(vis[it] == false){                   //agr not visited hai to visit krao
                dfs(it, vis, adj, ans);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>ans = new ArrayList<>();  //to store the ans
        boolean vis[] = new boolean[V+1];      //for visited array 
        vis[0] = true;        //first element uthao and vis ko true mark kr do
        dfs(0, vis, adj, ans);
        return ans;
    }
}