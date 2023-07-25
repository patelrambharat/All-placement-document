// 1315. Sum of Nodes with Even-Valued Grandparent
// Medium
// 2.5K
// 72
// Companies
// Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

// A grandparent of a node is the parent of its parent if it exists.

 

// Example 1:


// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 18
// Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
// Example 2:


// Input: root = [1]
// Output: 0
 
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
    int sum = 0;
    public void getsum(TreeNode root, TreeNode pare, TreeNode gp){
        if(root == null){
            return;
        }
        if(gp != null && gp.val %2 == 0){
            sum += root.val;
        }
        getsum(root.left, root, pare);
        getsum(root.right, root, pare);
    }
    public int sumEvenGrandparent(TreeNode root) {
        getsum(root, null, null);
        return sum;
    }
}