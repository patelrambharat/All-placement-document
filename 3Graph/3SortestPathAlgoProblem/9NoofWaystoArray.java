G-40: Number of Ways to Arrive at Destination
You are in a city that consists of n intersections numbered from 0 to n – 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n – 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

Example 1:
Input:
n=7, m=10
edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output:
4
Explanation: 
The four ways to get there in 7 minutes (which is the shortest calculated time) are:
- 0  6
- 0  4  6
- 0  1  2  5  6
- 0  1  3  5  6
Example 2:
Input:
n=6, m=8
edges= [[0,5,8],[0,2,2],[0,1,1],[1,3,3],[1,2,3],[2,5,6],[3,4,2],[4,5,2]]
Output:
3
Explanation: 
The three ways to get there in 8 minutes (which is the shortest calculated time) are:
- 0  5
- 0  2  5
- 0  1  3  4  5

// Initial configuration:

// Priority Queue: Define a Priority Queue which would contain pairs of the type {dist, node }, where ‘dist’ indicates the currently updated value of the shortest dist taken to reach from source to the current ‘node’.
// Distance Array: Define a distance array that would contain the minimum distance from the start node to the current node. If a cell is marked as ‘infinity’ then it is treated as unreachable/ unvisited.
// Source Node: Define the start node from where we have to calculate the total number of shortest paths.
// Ways Array: Define a ways array which would contain the number of possible shortest ways/paths for each node. Eventually, we would want to return ways[n-1] where n= Number of nodes.

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {

    static int countPaths(int n, List < List < Integer >> roads) {

        // Creating an adjacency list for the given graph.
        ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        
        // Defining a priority queue (min heap). 
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > ((x, y) -> x.first - y.first);

        // Initializing the dist array and the ways array
        // along with their first indices.
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } 

                    // If we again encounter a node with the same short distance
                    // as before, we simply increment the no. of ways.
                    else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;
    }
}



// Time Complexity: O( E* log(V)) { As we are using simple Dijkstra’s algorithm here, the time complexity will be or the order E*log(V)}

// Where E = Number of edges and V = No. of vertices.

// Space Complexity :  O(N) { for dist array + ways array + approximate complexity for priority queue }

// Where, N = Number of nodes.