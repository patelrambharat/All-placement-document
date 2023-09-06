// 207. Course Schedule
// Medium
// 14.9K
// 591
// Companies
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.



// DfS aporoach

class Solution {
    public boolean canFinish(int cources, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList();
        int[] visited = new int[cources];
        for(int i=0;i<cources;i++){
            List<Integer> l0 = new ArrayList();
            adj.add(l0);
        }
        for(int[] req :prereq){
            adj.get(req[0]).add(req[1]);
        }

        for(int i=0;i<cources;i++){
            if(visited[i]==0)
                if(!DFS(i,adj, visited)){ return false;}
        }
        return true;
    }

    public boolean DFS(int index,List<List<Integer>> adj,int[] visited ){
        if(visited[index]==2) return true;
        if(visited[index]==1) return false;
        visited[index]=1;
        List<Integer> l1 = adj.get(index);
        for(int child:l1){
            if(!DFS(child, adj, visited)) return false;
        }
        visited[index]=2;
        //System.out.println("Returning true at "+ index);
        return true;
    }

}