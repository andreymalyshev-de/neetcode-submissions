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

    int count = 0;

    public int goodNodes(TreeNode root) {
        help(root, Integer.MIN_VALUE);
        return count;
    }

    public void help(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) {
            max = root.val;
            count++;
        }

        help(root.left, max);
        help(root.right, max);
    }
}
