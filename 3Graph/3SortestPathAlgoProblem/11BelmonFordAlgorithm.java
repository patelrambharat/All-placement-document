// Bellman Ford Algorithm: G-41
// Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.

// Note: If the Graph contains a negative cycle then return an array consisting of only -1.

// Example 1:

// Input Format: 
// V = 6, 
// E = [[3, 2, 6], [5, 3, 1], [0, 1, 5], [1, 5, -3], [1, 2, -2], [3, 4, -2], [2, 4, 3]], 
// S = 0

// Result: 0 5 3 3 1 2
// Explanation: Shortest distance of all nodes from the source node is returned.
// Example 2:

// Input Format: V = 2, E = [[0,1,9]],  S = 0

// Result: 0 9
// Explanation: Shortest distance of all nodes from the source node is returned.

// The bellman-Ford algorithm helps to find the shortest distance from the source node to all other nodes. But, we have already learned Dijkstra’s algorithm (Dijkstra’s algorithm article link) to fulfill the same purpose. Now, the question is how this algorithm is different from Dijkstra’s algorithm.

// While learning Dijkstra’s algorithm, we came across the following two situations, where Dijkstra’s algorithm failed:

// If the graph contains negative edges.
// If the graph has a negative cycle (In this case Dijkstra’s algorithm fails to minimize the distance, keeps on running, and goes into an infinite loop. As a result it gives TLE error).
// Negative Cycle: A cycle is called a negative cycle if the sum of all its weights becomes negative. The following illustration is an example of a negative cycle:


// Bellman-Ford’s algorithm successfully solves these problems. It works fine with negative edges as well as it is able to detect if the graph contains a negative cycle. But this algorithm is only applicable for directed graphs. In order to apply this algorithm to an undirected graph, we just need to convert the undirected edges into directed edges like the following:


// Explanation: An undirected edge between nodes u and v necessarily means that there are two opposite-directed edges, one towards node u and the other towards node v. So the above conversion is valid.

// After converting the undirected graph into a directed graph following the above method, we can use the Bellman-Ford algorithm as it is. 

// Initial Configuration:

// distance array(dist[ ]): The dist[] array will be initialized with infinity, except for the source node as dist[src] will be initialized to 0.

// The algorithm steps will be the following:

// First, we will initialize the source node in the distance array to 0 and the rest of the nodes to infinity.
// Then we will run a loop for N-1 times.
// Inside that loop, we will try to relax every given edge.
// For example, one of the given edge information is like (u, v, wt), where u = starting node of the edge, v = ending node, and wt = edge weight. For all edges like this we will be checking if node u is reachable and if the distance to reach v through u is less than the distance to v found until now(i.e. dist[u] and dist[u]+ wt < dist[v]).
// After repeating the 3rd step for N-1 times, we will apply the same step one more time to check if the negative cycle exists. If we found further relaxation is possible, we will conclude the graph has a negative cycle and from this step, we will return a distance array of -1(i.e. minimization of distances is not possible).
// Otherwise, we will return the distance array which contains all the minimized distances.
// Note: If you wish to see the dry run of the above approach, you can watch the video attached to this article.

class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[S] = 0;
        // V x E
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}