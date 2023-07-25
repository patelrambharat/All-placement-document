// 2322. Minimum Score After Removals on a Tree
// Hard
// 402
// 13
// Companies
// There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

// You are given a 0-indexed integer array nums of length n where nums[i] represents the value of the ith node. You are also given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

// Remove two distinct edges of the tree to form three connected components. For a pair of removed edges, the following steps are defined:

// Get the XOR of all the values of the nodes for each of the three components respectively.
// The difference between the largest XOR value and the smallest XOR value is the score of the pair.
// For example, say the three components have the node values: [4,5,7], [1,9], and [3,3,3]. The three XOR values are 4 ^ 5 ^ 7 = 6, 1 ^ 9 = 8, and 3 ^ 3 ^ 3 = 3. The largest XOR value is 8 and the smallest XOR value is 3. The score is then 8 - 3 = 5.
// Return the minimum score of any possible pair of edge removals on the given tree.

 

// Example 1:


// Input: nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
// Output: 9
// Explanation: The diagram above shows a way to make a pair of removals.
// - The 1st component has nodes [1,3,4] with values [5,4,11]. Its XOR value is 5 ^ 4 ^ 11 = 10.
// - The 2nd component has node [0] with value [1]. Its XOR value is 1 = 1.
// - The 3rd component has node [2] with value [5]. Its XOR value is 5 = 5.
// The score is the difference between the largest and smallest XOR value which is 10 - 1 = 9.
// It can be shown that no other pair of removals will obtain a smaller score than 9.
// Example 2:


// Input: nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]
// Output: 0
// Explanation: The diagram above shows a way to make a pair of removals.
// - The 1st component has nodes [3,4] with values [4,4]. Its XOR value is 4 ^ 4 = 0.
// - The 2nd component has nodes [1,0] with values [5,5]. Its XOR value is 5 ^ 5 = 0.
// - The 3rd component has nodes [2,5] with values [2,2]. Its XOR value is 2 ^ 2 = 0.
// The score is the difference between the largest and smallest XOR value which is 0 - 0 = 0.
// We cannot obtain a smaller score than 0.
class Solution {
    ArrayList<Integer>[] graph;
    int[] values;
    int[] level;
    int[] xors;
    int[] parent;
    int[][] table;
    int MAXBIT=9;
    
    public int f(int src,int par,int lvl){
        xors[src]=values[src];
        level[src]=lvl;
        parent[src]=par;
        
        for(int nbr:graph[src]){
            if(nbr!=par){
                xors[src]^=f(nbr,src,lvl+1);
            }
        }
        return xors[src];
    }
    
    public void fillTable(){
        table[0]=parent;
        int n=table[0].length;
        
        for(int i=1;i<=MAXBIT;i++){
            for(int j=1;j<n;j++){
                table[i][j]=table[i-1][table[i-1][j]];
            }
        }
    }
    
    public int getLca(int x,int y){
        if(level[y]>level[x]){
            int t=x;
            x=y;
            y=t;
        }
        
        int k=level[x]-level[y];
        for(int i=0;i<=MAXBIT;i++){
            if((k & (1<<i)) > 0){
                x=table[i][x];
            }
        }

        if(x==y) return x;
        
        for(int i=MAXBIT;i>=0;i--){
            int nx=table[i][x];
            int ny=table[i][y];
            if(nx!=ny){
                x=nx;
                y=ny;
            }
        }
        
        return parent[x];
    }
    
    public int minimumScore(int[] nums, int[][] edges) {
        int n=nums.length;
        int m=edges.length;
        graph=new ArrayList[n];
        xors=new int[n];
        level=new int[n];
        parent=new int[n];
        table=new int[MAXBIT+1][n];
        values=nums;        
        
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        f(0,0,1);
        
        fillTable();
        
        int score=Integer.MAX_VALUE;
        int a,b,c;
        for(int i=1;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                
                int lca=getLca(i,j);

                if(lca==i){
                    a=xors[0]^xors[i];
                    b=xors[i]^xors[j];
                    c=xors[j];
                } 
                else if(lca==j){
                    a=xors[0]^xors[j];
                    b=xors[j]^xors[i];
                    c=xors[i];
                }
                else{
                    a=xors[0]^xors[i]^xors[j];
                    b=xors[i];
                    c=xors[j];
                }
                score=Math.min(score, Math.max(a,Math.max(b,c))-Math.min(a,Math.min(b,c)));
            }
        }
        
        return score;
    }
}