// Number of Provinces
// Problem Statement: Given an undirected graph with V vertices. We say two vertices
//  u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

// Pre-req: Connected Components, Graph traversal techniques


// A province is a group of directly or indirectly connected cities and no other cities outside of the group. '
// Considering the above example, we can go from 1 to 2 as well as to 3, from every other node in a province we 

// can go to each other. As we cannot go from 2 to 4 so it is not a province. We know about both the traversals'
// , Breadth First Search (BFS) and Depth First Search (DFS). We can use any of the traversals to solve this 
// problem because a traversal algorithm visits all the nodes in a graph. In any traversal technique, 
// we have one starting node and it traverses all the nodes in the graph. Suppose there is an ‘N’ number of provinces 
// so we need to call the traversal algorithm ‘N‘ times, i.e., there will be ‘N’ starting nodes. So, we just need to figure 
// out the number of starting nodes.

// DFS algorithm Approach
// The algorithm steps are as follows:

// We need a visited array initialized to 0, representing the nodes that are not visited.
// Run the for loop looping from 0 to N, and call the DFS for the first unvisited node. 
// DFS function call will make sure that it starts the DFS call from that unvisited node, and visits all the nodes that are in that province, and at the same time, it will also mark them as visited. 
// Since the nodes traveled in a traversal will be marked as visited, they will no further be called for any further DFS traversal. 
// Keep repeating these steps, for every node that you find unvisited, and visit the entire province. 
// Add a counter variable to count the number of times the DFS function is called, as in this way we can count the total number of starting nodes, which will give us the number of provinces.


class Solution {
    public void dfs(int node, int vis[] , ArrayList<ArrayList<Integer>>adjli){
        vis[node] =1;
        for(Integer it : adjli.get(node)){
            if(vis[it] == 0){
                dfs(it, vis , adjli);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>>adjli = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adjli.add(new ArrayList<Integer>());
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] ==1 &&  i != j){
                    adjli.get(i).add(j);
                    adjli.get(j).add(i);
                } 
            }
        }
        int cnt = 0;
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i, vis, adjli);
            }
        }
        return cnt;
    }
}


// Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph, and we 
// know DFS takes a time of O(V+2E). 

// Space Complexity: O(N) + O(N),Space for recursion stack space and visited array.
//BFS approach

class Solution {

    void bfs(ArrayList<ArrayList<Integer>> adj, int V, int s, boolean[] visited){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[s] = true;
        q.add(s);
        
        while(q.isEmpty() == false){
            int u = q.poll();
            for(int v: adj.get(u)){
                if(visited[v] == false){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        
        for(int i=0;i<V;i++)
            adjLs.add(new ArrayList<Integer>());
        
         for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(i).add(j);
                }
            }
        }
        
        int count=0;

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    bfs(adjLs,V,i,visited);
                    count++;
                }
            }
            
        return count;

  
    }
}
