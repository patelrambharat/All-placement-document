// // Construct BinaryTree From PostOrder and InOrder Traversal | Leetcode 106 Solution

// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Medium
// 7.4K
// 114
// Companies
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
 
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
    public TreeNode buildTreePostIn(int inorder[] , int is, int ie , int postorder[] , int ps, int pe, HashMap<Integer, Integer>hm){
        if(ps > pe || is > ie ) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inroot = hm.get(postorder[pe]);
        int numsleft = inroot  - is;
        root.left = buildTreePostIn(inorder, is, inroot -1, postorder, ps , ps +numsleft - 1, hm);
        root.right = buildTreePostIn(inorder, inroot +1, ie, postorder, ps + numsleft, pe -1, hm);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length  != postorder.length){
            return null;
        }
        HashMap<Integer,Integer>hm = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i] , i);
        }
        return buildTreePostIn(inorder, 0, inorder.length -1, postorder, 0, postorder.length - 1, hm);

    }
}