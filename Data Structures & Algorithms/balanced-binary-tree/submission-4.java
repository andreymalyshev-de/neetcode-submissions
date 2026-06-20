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

    private boolean valid = true;
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        length(root);
        return valid;
    }

    public int length(TreeNode root) {
        if (root == null) return 0;

        int a = length(root.left);
        if (a < 0) return -1;
        int b = length(root.right);
        if (b < 0) return -1;

        if (Math.abs(a - b) > 1) {
            valid = false;
            return -1;
        }

        return Math.max(a, b) + 1;
    }
}
