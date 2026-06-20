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
        if (root == null) return 0;

        int a = length(root.left);
        int b = length(root.right);

        if (a + b > max) max = a + b;
    
        return Math.max(Math.max(max, a), b);
    }

    public int length(TreeNode root) {
        if (root == null) return 0;

        int a = length(root.left);
        int b = length(root.right);
        System.out.println("node: " + root.val + " a: " + a + " b: " + b);

        if (a + b > max) max = a + b;
        System.out.println(max);
        return Math.max(a + 1, b + 1);
    }
}
