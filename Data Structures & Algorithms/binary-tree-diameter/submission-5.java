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

    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        length(root);
    
        return max;
    }

    public int length(TreeNode root) {
        if (root == null) return 0;

        int a = length(root.left);
        int b = length(root.right);

        if (a + b > max) max = a + b;

        return Math.max(a + 1, b + 1);
    }
}
