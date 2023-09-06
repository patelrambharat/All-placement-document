// Find Eventual Safe States – BFS – Topological Sort: G-25
// Problem Statement: A directed graph of V vertices and E edges is given in the form of an adjacency list adj. Each node of the graph is labeled with a distinct integer in the range 0 to V – 1. A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node. You have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

// Example 1:
// Input Format: N = 7, E = 7

// Result: {2 4 5 6}

// Explanation: Here terminal nodes are 5 and 6 as they 
// have no outgoing edges.
// From node 0: two paths are there 0->2->5 and 0->1->3->0. 
// The second path does not end at a terminal node. 
// So it is not a safe node.
// From node 1: two paths exist: 1->3->0->1 and 1->2->5. 
// But the first one does not end at a terminal node. 
// So it is not a safe node.
// From node 2: only one path: 2->5 and 5 is a terminal 
// node. So it is a safe node.
// From node 3: two paths: 3->0->1->3 and 3->0->2->5 but 
// the first path does not end at a terminal node. 
// So it is not a safe node.
// From node 4: Only one path: 4->5 and 5 is a terminal node. 
// So it is also a safe node.
// From node 5: It is a terminal node. So it is a safe node 
// as well.
// From node 6: It is a terminal node. 
// So it is a safe node as well.

// A terminal node is a node without any outgoing edges(i.e outdegree = 0). Now a node is considered to be a safe node if all possible paths starting from it lead to a terminal node. Here we need to find out all safe nodes and return them sorted in ascending order. If we closely observe, all possible paths starting from a node are going to end at some terminal node unless there exists a cycle and the paths return back to themselves. Let’s understand it considering the below graph:


// In the above graph, there exists a cycle i.e 0->1->3->0, and node 7 is connected to the cycle with an incoming edge towards the cycle. 
// Some paths starting from these nodes are definitely going to end somewhere in the cycle and not at any terminal node. So, these nodes are not safe nodes.
// Though node 2 is connected to the cycle, the edge is directed outwards the cycle and all the paths starting from it lead to the terminal node 5. So, it is a safe node and the rest of the nodes (4, 5, 6) are safe nodes as well.



// Initial Configuration:
// Indegree Array: Initially all elements are set to 0. Then, We will count the incoming edges for a node and store it in this array. For example, if indegree of node 3 is 2, indegree[3] = 2. If you don’t know how to find indegrees, you can refer to the step 2 in the algorithm. 

// Queue: As we will use BFS, a queue is required. Initially, the node with indegree 0 will be pushed into the queue.

// safeNodes array: Initially empty and is used to store the safe nodes.

// The algorithm steps are as follows:

// First, we will reverse all the edges of the graph so that we can apply the topological sort algorithm afterward.
// Then, we will calculate the indegree of each node and store it in the indegree array. We can iterate through the given adj list, and simply for every node u->v, we can increase the indegree of v by 1 in the indegree array. 
// Then, we will push the node(s) with indegree 0 into the queue.
// Then, we will pop a node from the queue including the node in our safeNodes array, and for all its adjacent nodes, we will decrease the indegree of that node by one. For example, if node u that has been popped out from the queue has an edge towards node v(u->v), we will decrease indegree[v] by 1.
// After that, if for any node the indegree becomes 0, we will push that node again into the queue.
// We will repeat steps 3 and 4 until the queue is completely empty. Finally, completing the BFS we will get the linear ordering of the nodes in the safeNodes array.
// Finally, the safeNodes array will only consist of the nodes that are neither a part of any cycle nor connected to any cycle. Then we will sort the final safeNodes array as the question requires the answer in sorted order.

class Solution {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}


// Time Complexity: O(V+E)+O(N*logN), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm. Extra O(N*logN) for sorting the safeNodes array, where N is the number of safe nodes.

// Space Complexity: O(N) + O(N) + O(N) ~ O(3N), O(N) for the indegree array, O(N) for the queue data structure used in BFS(where N = no.of nodes), and extra O(N) for the adjacency list to store the graph in a reversed order.

