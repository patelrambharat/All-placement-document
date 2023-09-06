// Dijkstra’s Algorithm – Using Set : G-33
// Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two
//  integers where the first integer of each list j denotes there is an edge between i and j, second integers corresponds to the weight of that edge. You are given the source vertex S and You have to Find the shortest distance of all the vertex from the source vertex S. You have to return a list of integers denoting the shortest distance between each node and Source vertex S.
// Note: The Graph doesn’t contain any negative weight cycle
// Example 1:
// Input:

// V = 2
// adj [] = {{{1, 9}}, {{0, 9}}}
// S = 0

// Output:
// 0 9

// Explanation: :
// The source vertex is 0. Hence, the shortest distance of node 0 
// from the source is 0 and the shortest distance of node 1 from 
// source will be 9.

// The Algorithm consists of the following steps :

// We would be using a set and a distance array of size V (where ‘V’ are the number of nodes in the graph) initialized with infinity (indicating that at present none of the nodes are reachable from the source node) and initialize the distance to source node as 0.
// We push the source node to the set along with its distance which is also 0.
// Now, we start erasing the elements from the set and look out for their adjacent nodes one by one. If the current reachable distance is better than the previous distance indicated by the distance array, we update the distance and insert it in the set.
// A node with a lower distance would be first erased from the set as opposed to a node with a higher distance. By following step 3, until our set becomes empty, we would get the minimum distance from the source node to all other nodes. We can then return the distance array. 
// The only difference between using a Priority Queue and a Set is that in a set we can check if there exists a pair with the same node but a greater distance than the current inserted node as there will be no point in keeping that node into the set if we come across a much better value than that. So, we simply delete the element with a greater distance value for the same node.
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Create a priority queue to store pairs (distance, node) in increasing order of distance.
        // The pair with the smallest distance will be at the front of the queue.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        // Create an array to store the shortest distances from the source node to all other nodes.
        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = (int) (1e9); // Initialize distances to a very large value.

        dist[S] = 0; // Set the distance of the source node to 0.
        pq.add(new Pair(0, S)); // Add the source node to the priority queue with distance 0.

        while (pq.size() != 0) {
            int dis = pq.peek().distance; // Get the distance of the node at the front of the priority queue.
            int node = pq.peek().node; // Get the node at the front of the priority queue.
            pq.remove(); // Remove the pair from the priority queue.

            // Iterate through all the adjacent nodes of the current node.
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1); // Get the weight of the edge.
                int adjNode = adj.get(node).get(i).get(0); // Get the adjacent node.

                // If the distance through the current node is smaller than the previously calculated distance,
                // update the distance and add the pair (distance, node) to the priority queue.
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist; // Return the array of shortest distances.
    }
}


// Note: This set approach cannot be implemented in JAVA by using TreeSet or HashSet. For implementing Dijkstra’s Algorithm in JAVA, we would use a priority queue only.

// Time Complexity : O( E log(V) ) 

// Where E = Number of edges and V = Number of Nodes.

// Space Complexity : O( |E| + |V| ) 

// Where E = Number of edges and V = Number of Nodes.

