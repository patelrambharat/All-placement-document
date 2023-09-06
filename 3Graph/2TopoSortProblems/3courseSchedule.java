// Course Schedule I and II | Pre-requisite Tasks | Topological Sort: G-24
// Problem Statement I (Course Schedule): There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks, for example, to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]

// Given the total number of n tasks and a list of prerequisite pairs of size m. Find the order of tasks you should pick to finish all tasks.

// Note: There may be multiple correct orders, you need to return one of them. If it is impossible to finish all tasks, return an empty array.

// Problem Statement II (Pre-requisite Tasks): There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example, to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]

// Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.

// Note: These two questions are linked. The second question asks if it is possible to finish all the tasks and the first question states to return the ordering of the tasks if it is possible to perform all the tasks, otherwise return an empty array.

// Examples:

// Example 1:
// Input: N = 4, P = 3,  array[] = {{1,0},{2,1},{3,2}}
// Output: Yes
// Explanation: It is possible to finish all the tasks in the order : 3 2 1 0.
// First, we will finish task 3. Then we will finish task 2, task 1, and task 0.

// Example 2:
// Input: N = 4, P = 4,  array[] = {{1,2},{4,3},{2,4},{4,1}}
// Output: No
// Explanation: It is impossible to finish all the tasks. Let’s analyze the pairs:
// For pair {1, 2} -> we need to finish task 1 first and then task 2. (order : 1 2).
// For pair{4, 3} -> we need to finish task 4 first and then task 3. (order: 4 3).
// For pair {2, 4} -> we need to finish task 2 first and then task 4. (order: 1 2 4 3).
// But for pair {4, 1} -> we need to finish task 4 first and then task 1 but this pair contradicts the previous pair. So, it is not possible to finish all the tasks.

// The solutions will be similar for both questions as we need to check for one, and in the other, we need to print the order. 
// The questions state that the given pairs signify the dependencies of tasks. For example, the pair {u, v} signifies that to perform task v,
//  first we need to finish task u. Now, if we closely observe, we can think of a directed edge between u and v(u -> v)
//   where u and v are two nodes. Now, if we can think of each task as a node and every pair as a directed edge between those two nodes, 
//   the whole problem becomes a graph problem.

// For the first problem(Course Schedule): We will return the answer array if the length of the ordering equals the number of tasks. Otherwise, we will return an empty array.
// For the Second problem(Prerequisite tasks): We will return true if the length of the ordering equals the number of tasks. otherwise, we will return false.

  static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }



        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }


        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        int topo[] = new int[n];
        int ind = 0;
        // o(v + e)
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo[ind++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }


        if (ind == n) return topo;
        int[] arr = {};
        return arr;
    }