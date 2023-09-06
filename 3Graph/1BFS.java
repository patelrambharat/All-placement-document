// Breadth First Search (BFS): Level Order Traversal
// Problem Statement: Given an undirected graph, return a vector of all nodes by traversing the graph using breadth-first search (BFS).

// Pre-req: Graph Representation, Queue STL

// Approach:
// Initial Configuration:

// Queue data structure: follows FIFO, and will always contain the starting.
// Visited array: an array initialized to 0

// In BFS, we start with a “starting” node, mark it as visited, and push it into the queue data structure.
// In every iteration, we pop out the node ‘v’ and put it in the solution vector, as we are traversing this node.
// All the unvisited adjacent nodes from ‘v’ are visited next and are pushed into the queue. The list of adjacent neighbors of the node can be accessed from the adjacency list.
// Repeat steps 2 and 3 until the queue becomes empty, and this way you can easily traverse all the nodes in the graph.

  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>ans = new ArrayList<>();
        boolean vis[] = new boolean[V+1];
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
        
    }
}


// Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

// Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list


