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
// Example 2:


// Dijkstra’s Shortest Path algorithm and Bellman-Ford algorithm are single-source shortest path algorithms where we are given a single source node and are asked to find out the shortest path to every other node from that given source. But in the Floyd Warshall algorithm, we need to figure out the shortest distance from each node to every other node.

// Basically, the Floyd Warshall algorithm is a multi-source shortest path algorithm and it helps to detect negative cycles as well. The shortest path between node u and v necessarily means the path(from u to v) for which the sum of the edge weights is minimum.

// matrix[i][j] =min(matrix[i][j], matrix[i ][k]+matrix[k][j]), where i = source node, j = destination node, and k = the node via which we are reaching from i to j.

// Here we will calculate dist[i][j] for every possible node k (k = 0, 1….V, where V = no. of nodes), and will select the minimum value as our result.

// In order to apply this algorithm to an undirected graph, we just need to convert the undirected edges into directed edges like the following:

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
}


// Time Complexity: O(V3), as we have three nested loops each running for V times, where V = no. of vertices.

// Space Complexity: O(V2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph.

