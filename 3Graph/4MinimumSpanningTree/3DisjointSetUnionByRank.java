// Disjoint Set | Union by Rank | Union by Size | Path Compression: G-46
// In this article, we will discuss the Disjoint Set data structure which is a very important topic in the entire graph series.
//  Let’s first understand why we need a Disjoint Set data structure using the below question:

// Question: Given two components of an undirected graph


// The question is whether node 1 and node 5 are in the same component or not.

// Now, in order to solve this question we can use either the DFS or BFS traversal technique like if we traverse the components of the graph we can find that node 1 and node 5 are not in the same component. This is actually the brute force approach whose time complexity is O(N+E)(N = no. of nodes, E = no. of edges). But using a Disjoint Set data structure we can solve this same problem in constant time.

// The disjoint Set data structure is generally used for dynamic graphs. 

// Dynamic graph:
// A dynamic graph generally refers to a graph that keeps on changing its configuration. Let’s deep dive into it using an example:

// Let’s consider the edge information for the given graph as: {{1,2}, {2,3}, {4,5}, {6,7}, {5,6}, {3,7}}. Now if we start adding the edges one by one, in each step the structure of the graph will change. So, after each step, if we perform the same operation on the graph while updating the edges, the result might be different. In this case, the graph will be considered a dynamic graph.
// For example, after adding the first 4 edges if we look at the graph, we will find that node 4 and node 1 belong to different components but after adding all 6 edges if we search for the same we will figure out that node 4 and node 1 belong to the same component.



// So, after any step, if we try to figure out whether two arbitrary nodes u and v belong to the same component or not, Disjoint Set will be able to answer this query in constant time.
// Functionalities of Disjoint Set data structure:
// The disjoint set data structure generally provides two types of functionalities:

// Finding the parent for a particular node (findPar())
// Union (in broad terms this method basically adds an edge between two nodes)
// Union by rank
// Union by size
// First, we will be discussing Union by rank and then Union by size.

// Union by rank:
// Before discussing Union by rank we need to discuss some terminologies:

// Rank:

// The rank of a node generally refers to the distance (the number of nodes including the leaf node) between the furthest leaf node and the current node. Basically rank includes all the nodes beneath the current node.


// Ultimate parent:

// The parent of a node generally refers to the node right above that particular node. But the ultimate parent refers to the topmost node or the root node.


// Now let’s discuss the implementation of the union by rank function. In order to implement Union by rank, we basically need two arrays of size N(no. of nodes). One is the rank and the other one is the parent. The rank array basically stores the rank of each node and the parent array stores the ultimate parent for each node.

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


// Follow-up question:
// In the union by rank method, why do we need to connect the smaller rank to the larger rank?

// the traversal time to find the ultimate parent for only nodes 1 and 2 increases. So the path compression time becomes relatively lesser than in the previous case. So, we can conclude that we should always connect a smaller rank to a larger one with the goal of
// shrinking the height of the graph.
// reducing the time complexity as much as we can.

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


// Time Complexity:  The time complexity is O(4) which is very small and close to 1. So, we can consider 4 as a constant.

