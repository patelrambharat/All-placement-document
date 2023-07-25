// 1192. Critical Connections in a Network
// Hard
// 5.7K
// 173
// Companies
// There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

// A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

// Return all critical connections in the network in any order.

 

// Example 1:


// Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// Output: [[1,3]]
// Explanation: [[3,1]] is also accepted.
// Example 2:

// Input: n = 2, connections = [[0,1]]
// Output: [[0,1]]
 

// Constraints:

// 2 <= n <= 105
// n - 1 <= connections.length <= 105
// 0 <= ai, bi <= n - 1
// ai != bi
// There are no repeated connections.

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int time[] = new int[n];
        int low[] = new int[n];

        boolean visited[] = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < connections.size(); i++) {
            graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));

        }

        for(int i = 0; i < n; i++) {
            System.out.println(i + " : " + graph.get(i));
        }
        
        dfs(graph, 0, time, 1, low, visited, ans, -1);
        return ans;
    }

    public void dfs(List<List<Integer>> graph, int source, int []time, int prevtime, int[] low, boolean []visited, List<List<Integer>> ans, int parent) {

        visited[source] = true;
        time[source] = prevtime;
        low[source] = prevtime;

        for(int ele : graph.get(source)) {
            if(!visited[ele])
                dfs(graph, ele, time, prevtime+1, low, visited, ans, source);
            // System.out.println(source + " : " + time[source]);
            // System.out.println(source + " : " + low[source]);
            // System.out.println(ele + " : " + time[ele]);
            // System.out.println(ele + " : " + low[ele]);
            if(time[source] < low[ele]) 
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(source);
                temp.add(ele);
                ans.add(temp);
                System.out.println(temp);
            }
            if(low[source] > low[ele] & ele != parent)
                low[source] = low[ele];

        }
    }
}