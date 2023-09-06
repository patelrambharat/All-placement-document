// Topological Sort Algorithm | DFS: G-21
// Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

// Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).

// Example 1:

// Input: V = 6, E = 6

// Output: 5, 4, 2, 3, 1, 0
// Explanation: A graph may have multiple topological sortings. 
// The result is one of them. The necessary conditions 
// for the ordering are:
// According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
// According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
// According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
// According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
// According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
// According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.

// The above result satisfies all the necessary conditions. 
// [4, 5, 2, 3, 1, 0] is also one such topological sorting 
// that satisfies all the conditions.

// Topological sorting only exists in Directed Acyclic Graph (DAG). If the nodes of a graph are connected through directed edges and the graph does not contain a cycle, it is called a directed acyclic graph(DAG). 

// The topological sorting of a directed acyclic graph is nothing but the linear ordering of vertices such that if there is an edge between node u and v(u -> v), node u appears before v in that ordering.

// Now, let’s understand Why topological sort only exists in DAG:

// Case 1 (If the edges are undirected): If there is an undirected edge between node u and v, it signifies that there is an edge from node
//  u to v(u -> v) as well as there is an edge from node v to u(v -> u). But according to the definition of topological sorting, it is 
//  practically impossible to write such ordering where u appears before v and v appears before u simultaneously. So, it is only possible 
//  for directed edges.
// Case 2(If the directed graph contains a cycle): The following directed graph contains a cycle:


// If we try to get topological sorting of this cyclic graph, for edge 1->2, node 1 must appear before 2, for edge 2->3, node 2 must 
// appear before 3, and for edge 3->1, node 3 must appear before 1 in the linear ordering. But such ordering is not possible 
// as there exists a cyclic dependency in the graph. Thereby, topological sorting is only possible for a directed acyclic graph.

// The algorithm steps are as follows:

// We must traverse all components of the graph.
// Make sure to carry a visited array(all elements are initialized to 0) and a stack data structure, where we are going to store the nodes after completing the DFS call.
// In the DFS call, first, the current node is marked as visited. Then DFS call is made for all its adjacent nodes.
// After visiting all its adjacent nodes, DFS will backtrack to the previous node and meanwhile, the current node is pushed into the stack.
// Finally, we will get the stack containing one of the topological sortings of the graph.

 private static void dfs(int node, int vis[], Stack<Integer> st,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
}


// Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.

// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for recursive stack space, where N = no. of nodes.

