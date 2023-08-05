// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Medium
// 13.5K
// 405
// Companies
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
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
    public TreeNode buildTree(int preorder[] , int prestart , int preend , int inorder[] , int instart, int inend, Map<Integer, Integer>inmap){
        if(prestart > preend || instart > inend)  return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = inmap.get(root.val);
        int numsleft  = inroot - instart;
        root.left  = buildTree(preorder, prestart +1, prestart + numsleft, inorder,instart, inroot - 1, inmap);
        root.right = buildTree(preorder, prestart +numsleft +1, preend , inorder, inroot +1, inend , inmap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer>inMap = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1, inMap);
        return root;

    }
}