// // For each node, first, the node is visited and then it’s child nodes are put in a FIFO queue. Then again the first node is popped out and then it’s child nodes are put in a FIFO queue and repeat until queue becomes empty.

// 102. Binary Tree Level Order Traversal
// Medium
// 13.9K
// 273
// Companies
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>lo = new ArrayList<>();
        if(root == null){
            return lo;
        }
        Queue<TreeNode>q  = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer>currlevel = new ArrayList<>();
            while(size-- > 0){
                TreeNode rnode = q.peek();
                q.remove();
                currlevel.add(rnode.val);
                if(rnode.left != null){
                    q.add(rnode.left);
                }
                if(rnode.right != null){
                    q.add(rnode.right);
                } 
            }
           lo.add(currlevel);
        }
        return lo;
    }
}