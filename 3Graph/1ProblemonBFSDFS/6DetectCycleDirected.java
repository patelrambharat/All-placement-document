// Detect cycle in a directed graph (using DFS) : G 19
// Problem Statement: Given a directed graph with V vertices and E edges, check whether it contains any cycle or not. 

// In a Directed Cyclic Graph, during traversal, if we end up at a node, which we have visited previously in the path, that means we 
// came around a circle and ended up at this node, which determines that it has a cycle. Previously, we have learned a similar technique 
// to detect cycles in an Undirected Graph (using DFS). In that method, the algorithm returns true, if it finds an adjacent node that is
//  previously visited and not a parent of the current node. But the same algorithm will not work in this case. Let’s understand why 
//  this happens considering the below graph.

// Let’s start DFS from node 1. It will follow the path 1->2->3->4->5->6, all the nodes including 5 will be visited as marked. 
// As there are no further nodes after node 6, DFS will backtrack to node 3 and will follow the path: 3->7->5->6. It followed this path because this path was left to be explored. 
// Reaching node 7, the adjacent node 5 can be found previously visited, but ideally, it should not have been visited, as we did not visit this node in a continuous path. At this point, the algorithm will conclude that this is a cycle and will return true but this is not a cycle as node 5 has been visited twice following two different paths.
// This would have been true if the nodes are connected to undirected edges. But as we are dealing with directed edges this algorithm fails to detect a cycle. 
// Due to the above reason, we need to think of an algorithm, which keeps a track of visited nodes, in the traversal only.

class Solution {
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1; 
        pathVis[node] = 1; 
        
        // traverse for adjacent nodes 
        for(int it : adj.get(node)) {
            // when the node is not visited 
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis) == true) 
                    return true; 
            }
            // if the node has been previously visited
            // but it has to be visited on the same path 
            else if(pathVis[it] == 1) {
                return true; 
            }
        }
        
        pathVis[node] = 0; 
        return false; 
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfsCheck(i, adj, vis, pathVis) == true) return true; 
            }
        }
        return false; 
    }
}


// Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.

// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.