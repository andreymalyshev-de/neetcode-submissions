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

    private int c = 0;

    public int kthSmallest(TreeNode root, int k) {
        return help(root, k).val;
    }

    public TreeNode help(TreeNode root, int k) {
        TreeNode res = null;
        //System.out.println(root.val);
        
        if (root.left != null) {
            res = help(root.left, k);
        }
        //System.out.println(root.val);
        c++;
        if (c == k) {
            return root;
        }
        else if (c > k) {
            return res;
        }
        else {
            if (root.right != null) {
                res = help(root.right, k);
            }
            return res;
        }
    }
}
