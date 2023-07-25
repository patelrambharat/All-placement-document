// 834. Sum of Distances in Tree
// Hard
// 4.7K
// 106
// Companies
// There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

// You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

// Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

// Example 1:


// Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
// Output: [8,12,6,10,10,10]
// Explanation: The tree is shown above.
// We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
// equals 1 + 1 + 2 + 2 + 2 = 8.
// Hence, answer[0] = 8, and so on.
// Example 2:


// Input: n = 1, edges = []
// Output: [0]
// Example 3:


// Input: n = 2, edges = [[1,0]]
// Output: [1,1]
 

// Constraints:

// 1 <= n <= 3 * 104
// edges.length == n - 1
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// The given input represents a valid tree.

class Solution {
    private int res[];   //store the res
    private int cnt[];   //store the cnt of each index
    private List<HashSet<Integer>>tree;     //build the input data in the form of adjacency list

    public void postorder(int root, int pre){
        for(int i: tree.get(root)){    //iterate over all the children of the given root
            if(i == pre)  continue;   //if pre == curr skip
            postorder(i, root);      //invoke
            cnt[root] += cnt[i];    //update cnt
            res[root] += res[i] + cnt[i];     //update the res with the ith element with the cnt
        }
        cnt[root]++;
    }
    public void preorder(int root , int pre){
        for(int i: tree.get(root)){
            if(i == pre)  continue;
            res[i] = res[root] - cnt[i] + cnt.length - cnt[i];
            preorder(i, root);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        cnt = new int[n];
        for(int i=0;i<n;i++){
            tree.add(new HashSet<Integer>());
        }
        for(int e[] : edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postorder(0, -1);     //it will responsible for cnt array also it will update the res
        preorder(0, -1);
        return res;
    }
}