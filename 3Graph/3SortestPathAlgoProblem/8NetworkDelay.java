// 743. Network Delay Time
// Companies
// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

// Example 1:


// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// Example 2:

// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// Example 3:

// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
 

// Constraints:

// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list to represent the graph
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        
        // Initialize the distance array to store minimum distances from the source node
        int[] dist = new int[n + 1];
        
        // Initialize the adjacency list for each node
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the adjacency list based on the given times array
        for (int[] time : times) {
            graph.get(time[0]).add(new Pair(time[1], time[2]));
        }
        
        // Initialize a priority queue for exploring nodes in order of their shortest distance
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Add the starting node to the priority queue with distance 0
        pq.add(new Pair(k, 0));
        
        // Initialize all distances to infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        // Explore nodes using Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            int cur = p.getKey();
            
            // Explore neighboring nodes and update distances
            for (Pair<Integer, Integer> neighbor : graph.get(cur)) {
                int curDist = neighbor.getValue() + dist[cur];
                
                // If the new distance is smaller, update and add to the priority queue
                if (curDist < dist[neighbor.getKey()]) {
                    dist[neighbor.getKey()] = curDist;
                    pq.add(new Pair(neighbor.getKey(), curDist));
                }
            }
        }
        
        // Find the maximum delay among all nodes
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Some nodes are unreachable, return -1
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        
        return maxDelay;
    }
}

