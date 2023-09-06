// Disjoint Set | Union by Rank | Union by Size | Path Compression: G-46
// In this article, we will discuss the Disjoint Set data structure which is a very important topic in the entire graph series. Let’s first understand why we need a Disjoint Set data structure using the below question:

// Question: Given two components of an undirected graph


// The question is whether node 1 and node 5 are in the same component or not.

// Approach:

// Now, in order to solve this question we can use either the DFS or BFS traversal technique like if we traverse the components of the graph we can find that node 1 and node 5 are not in the same component. This is actually the brute force approach whose time complexity is O(N+E)(N = no. of nodes, E = no. of edges). But using a Disjoint Set data structure we can solve this same problem in constant time.

// The disjoint Set data structure is generally used for dynamic graphs. 

// Initial configuration:

// rank array: This array is initialized with zero.

// parent array: The array is initialized with the value of nodes i.e. parent[i] = i.

// The algorithm steps are as follows:

// Firstly, the Union function requires two nodes(let’s say u and v) as arguments. Then we will find the ultimate parent (using the findPar() function that is discussed later) of u and v. Let’s consider the ultimate parent of u is pu and the ultimate parent of v is pv.
// After that, we will find the rank of pu and pv.
// Finally, we will connect the ultimate parent with a smaller rank to the other ultimate parent with a larger rank. But if the ranks are equal, we can connect any parent to the other parent and we will increase the rank by one for the parent node to whom we have connected the other one.
import java.io.*;
import java.util.*;
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}

class Main {
    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}