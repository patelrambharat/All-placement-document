// Floyd Warshall Algorithm: G-42
// Problem Statement: The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.

// Do it in place.

// Example 1:

// Input Format: 
// matrix[][] = { {0, 2, -1, -1},
//         {1, 0, 3, -1},{-1, -1, 0, -1},{3, 5, 4, 0} }

// Result:
// 0 2 5 -1 
// 1 0 3 -1 
// -1 -1 0 -1 
// 3 5 4 0 
// Explanation: In this example, the final matrix 
// is storing the shortest distances. For example, matrix[i][j] is 
// storing the shortest distance from node i to j.

// In this article, we will be discussing Floyd Warshall Algorithm which is very much different from the two which we have previously learned: Dijkstra’s Shortest Path algorithm and the Bellman-Ford algorithm. 

// Dijkstra’s Shortest Path algorithm and Bellman-Ford algorithm are single-source shortest path algorithms where we are given a single source node and are asked to find out the shortest path to every other node from that given source. But in the Floyd Warshall algorithm, we need to figure out the shortest distance from each node to every other node.

// Basically, the Floyd Warshall algorithm is a multi-source shortest path algorithm and it helps to detect negative cycles as well. The shortest path between node u and v necessarily means the path(from u to v) for which the sum of the edge weights is minimum.
// How to detect a negative cycle using the Floyd Warshall algorithm?
// Negative Cycle: A cycle is called a negative cycle if the sum of all its weights becomes negative. The following illustration is an example of a negative cycle:


// We have previously said that the cost of reaching a node from itself must be 0. But in the above graph, if we try to reach node 0 from itself we can follow the path: 0->1->2->0. In this case, the cost to reach node 0 from itself becomes -3 which is less than 0. This is only possible if the graph contains a negative cycle.
// So, if we find that the cost of reaching any node from itself is less than 0, we can conclude that the graph has a negative cycle.
// What will happen if we will apply Dijkstra’s algorithm for this purpose?
// If the graph has a negative cycle: We cannot apply Dijkstra’s algorithm to the graph which contains a negative cycle. It will give TLE error in that case.
// If the graph does not contain a negative cycle: In this case, we will apply Dijkstra’s algorithm for every possible node to make it work like a multi-source shortest path algorithm like Floyd Warshall. The time complexity of Floyd Warshall is O(V3)(Which we will discuss later in this article) whereas if we apply Dijkstra’s algorithm for the same purpose the time complexity reduces to O(V*(E*logV)) (where v = no. of vertices). 
// Approach: 

// The algorithm is not much intuitive as the other ones’. It is more of a brute force, where all combinations of paths have been tried to get the shortest paths. Nothing to panic much with the intuition, it is a simple brute force approach on all paths. Focus on the three ‘for’ loops.

// Formula:

// matrix[i][j] =min(matrix[i][j], matrix[i ][k]+matrix[k][j]), where i = source node,
//                   j = destination node and k = the node via which we are reaching from i to j.


  public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                                            matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
