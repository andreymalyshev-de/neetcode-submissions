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
        if (subRoot == null) return true;
        if (root == null) return false;

        if (root.val == subRoot.val) {
            if (check(root, subRoot)) return true;
        } 

        boolean flag = false;

        flag = isSubtree(root.left, subRoot);
        if (flag) return true;
        flag = isSubtree(root.right, subRoot);

        return flag;
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        //System.out.println(root + " " + subRoot);
        if (root == null || subRoot == null) return root == subRoot;
        if (root.val != subRoot.val) return false;

        //System.out.println("check");

        boolean flag = true;
        flag = check(root.left, subRoot.left);
        if (!flag) return false;
        flag = check(root.right, subRoot.right);

        return flag;
    }
}
