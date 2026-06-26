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

    int i = 0;
    int j = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(Integer.MAX_VALUE, preorder, inorder);
    }

    public TreeNode help(int limit, int[] preorder, int[] inorder) {
        if (i >= preorder.length) {
            return null;
        } 

        if (inorder[j] == limit) {
            j++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = help(root.val, preorder, inorder);
        root.right = help(limit, preorder, inorder);

        return root;
    }
}
