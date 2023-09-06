// Kahn’s Algorithm | Topological Sort Algorithm | BFS: G-22
// Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

// Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).

// Input Format: V = 6, E = 6

// Result: 5, 4, 0, 2, 3, 1
// Explanation: A graph may have multiple topological sortings. 
// The result is one of them. The necessary conditions for the ordering are:
// According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
// According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
// According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
// According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
// According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
// According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.

// The above result satisfies all the necessary conditions. 
// [4, 5, 2, 3, 1, 0] and [4, 5, 0, 2, 3, 1] are also such 
// topological sortings that satisfy all the conditions.

// Topological sorting only exists in Directed Acyclic Graph (DAG). If the nodes of a graph are connected through directed edges and the graph does not contain a cycle, it is called a directed acyclic graph(DAG). 

// The topological sorting of a directed acyclic graph is nothing but the linear ordering of vertices such that if there is an edge between node u and v(u -> v), node u appears before v in that ordering.

// Now, let’s understand Why topological sort only exists in DAG:

// Case 1 (If the edges are undirected): If there is an undirected edge between node u and v, it signifies that there is an edge from node u to v(u -> v) as well as there is an edge from node v to u(v -> u). But according to the definition of topological sorting, it is practically impossible to write such ordering where u appears before v and v appears before u simultaneously. So, it is only possible for directed edges.
// Case 2(If the directed graph contains a cycle): The following directed graph contains a cycle:


// If we try to get topological sorting of this cyclic graph, for edge 1->2, node 1 must appear before 2, for edge 2->3, node 2 must appear before 3, and for edge 3->1, node 3 must appear before 1 in the linear ordering. But such ordering is not possible as there exists a cyclic dependency in the graph. Thereby, topological sorting is only possible for a directed acyclic graph.
// Therefore, the intuition is to find the ordering in which the nodes are connected in a directed acyclic graph. For this, we will use a slightly modified version of BFS where we will be requiring a queue data structure(First In First Out data structure) and an array that will store the indegree of each node. The indegree of a node is the number of directed edges incoming towards it.


// Initial Configuration:

// Indegree Array: Initially all elements are set to 0. Then, We will count the incoming edges for a node and store it in this array. For example, if indegree of node 3 is 2, indegree[3] = 2.

// Queue: As we will use BFS, a queue is required. Initially, the node with indegree 0 will be pushed into the queue.

// Answer array: Initially empty and is used to store the linear ordering.

// The algorithm steps are as follows:

// First, we will calculate the indegree of each node and store it in the indegree array. We can iterate through the given adj list, and simply for every node u->v, we can increase the indegree of v by 1 in the indegree array. 
// Initially, there will be always at least a single node whose indegree is 0. So, we will push the node(s) with indegree 0 into the queue.
// Then, we will pop a node from the queue including the node in our answer array, and for all its adjacent nodes, we will decrease the indegree of that node by one. For example, if node u that has been popped out from the queue has an edge towards node v(u->v), we will decrease indegree[v] by 1.
// After that, if for any node the indegree becomes 0, we will push that node again into the queue.
// We will repeat steps 3 and 4 until the queue is completely empty. Finally, completing the BFS we will get the linear ordering of the nodes in the answer array.


   // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        ;
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }
}


// Output: 4 5 0 2 3 1

// Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

// Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).

