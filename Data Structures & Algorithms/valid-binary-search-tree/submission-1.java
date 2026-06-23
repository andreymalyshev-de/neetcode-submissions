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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        return help(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean help(TreeNode root, int min, int max) {
        int val = root.val;
        int lval = root.left == null ? min + 1 : root.left.val;
        int rval = root.right == null ? max - 1 : root.right.val;
        System.out.println(val + " " + lval + " " + rval);

        if (root.left == null && root.right == null) return true;
        else if (root.right == null) {
            if (val <= lval || lval <= min) return false;
            else return help(root.left, min, root.val);
        }
        else if (root.left == null) {
            if (val >= rval || rval >= max) return false;
            else return help(root.right, root.val, max);
        }
        else {

            if (val <= lval || val >= rval) return false;
            if (lval <= min || rval >= max) return false;

            return help(root.left, min, root.val) && help(root.right, root.val, max);
        }
    }
}
