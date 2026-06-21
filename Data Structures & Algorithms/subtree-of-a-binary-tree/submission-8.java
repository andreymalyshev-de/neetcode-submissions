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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String r = toString(root);
        String sr = toString(subRoot);
        System.out.println(r + " " + sr);

        return r.contains(sr);
    }

    public String toString(TreeNode root) {
        if (root == null) return "#";

        String s = "";
        s += root.val;

        s += toString(root.left);
        s += toString(root.right);

        return s;
    }
}
