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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return max; 
    }

    private int help(TreeNode root) {
        if (root == null) return 0;

        int valL = Math.max(0, help(root.left));
        int valR = Math.max(0, help(root.right));

        max = Math.max(max, root.val + valL + valR);

        return Math.max(root.val + valL, root.val + valR);
    }
}
