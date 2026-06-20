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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int a = length(root.left);
        int b = length(root.right);

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (left && right && Math.abs(a - b) < 2) return true;
        else return false;
    }

    public int length(TreeNode root) {
        if (root == null) return 0;

        int a = length(root.left);
        int b = length(root.right);

        return Math.max(a, b) + 1;
    }
}
