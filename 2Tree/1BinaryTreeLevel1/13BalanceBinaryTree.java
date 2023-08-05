// 110. Balanced Binary Tree
// Easy
// 9.5K
// 540
// Companies
// Given a binary tree, determine if it is 
// height-balanced
// .

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104

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
//0. Bruetforce Approach

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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh ) <= 1){
            return true;
        }
        return false;
    }
}



 //1. Optimize Approach 
class Solution {
    public class Pair{
        boolean isbalance;
        int height;
        Pair(boolean isbalance , int height){
            this.isbalance = isbalance;
            this.height = height;
        }
    }
    public Pair isbalance(TreeNode root){
        if(root == null){
            return new Pair(true, 0);
        }
        Pair left = isbalance(root.left);
        Pair right = isbalance(root.right);
        int lh = left.height;
        int rh = right.height;
        boolean rootisbalance = false;
        if(Math.abs(lh - rh) <=1){
            rootisbalance = true;
        }
        int height = Math.max(lh, rh) +1;
        if(rootisbalance == true && left.isbalance == true && right.isbalance == true){
            return new Pair(true, height);
        }
        else
            return new Pair(false, height);
    }
    public boolean isBalanced(TreeNode root) {
       Pair ans = isbalance(root);
       return ans.isBalanced;
    }
}