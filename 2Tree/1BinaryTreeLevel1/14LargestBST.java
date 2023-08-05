// 333. Largest BST Subtree
// Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

// Note:
// A subtree must include all of its descendants.

// Example:

// Input: [10,5,15,1,8,null,7]

//    10
//    / \
//   5  15
//  / \   \
// 1   8   7

// Output: 3
// Explanation: The Largest BST Subtree in this case is the highlighted one.
            //  The return value is the subtree's size, which is 3.
public class Largest_BST_Subtree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class Solution {

        private int max = 0;

        public int largestBSTSubtree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            dfs(root);

            return max;
        }

        private SubTreeData dfs(TreeNode root) {
            SubTreeData curr = new SubTreeData();
            if (root == null) {
                curr.isBST = true;
                return curr;
            }

            SubTreeData left = dfs(root.left);
            SubTreeData right = dfs(root.right);

            curr.lower = Math.min(root.val, Math.min(left.lower, right.lower));
            curr.upper = Math.max(root.val, Math.max(left.upper, right.upper));

            if (left.isBST && root.val > left.upper && right.isBST && root.val < right.lower) {
                curr.size = left.size + right.size + 1;
                curr.isBST = true;
                max = Math.max(max, curr.size);
            } else {
                curr.size = 0; // can delete, already is 0. just like isBST already false
            }

            return curr;
        }
    }

    class SubTreeData {
        int size = 0; // exclude root self
        int lower = Integer.MAX_VALUE;
        int upper = Integer.MIN_VALUE;
        boolean isBST = false;
    }
}

############

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
    private int ans;

    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left[1] < root.val && root.val < right[0]) {
            ans = Math.max(ans, left[2] + right[2] + 1);
            return new int[] {
                Math.min(root.val, left[0]), Math.max(root.val, right[1]), left[2] + right[2] + 1};
        }
        return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}