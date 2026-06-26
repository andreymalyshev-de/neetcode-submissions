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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int i = 0;
        int j = 0;
        TreeNode root = new TreeNode(preorder[i]);
        TreeNode res = root;
        i++;
        while (i < preorder.length && j < inorder.length) {

            System.out.println("po: " + preorder[i] + " io: " + inorder[j]);

            while (root.val == inorder[j] && i < preorder.length) {
                j++;
                if (root.right == null) {
                    //if (i >= preorder.length || j >= inorder.length) return res;
                    root.right = new TreeNode(preorder[i]);
                    root = root.right;
                    i++;
                }
                else {
                    if (root.right.val == inorder[j]) {
                        TreeNode tmp = root.right;
                        root.right = null;
                        root = tmp;
                    }
                    else {
                        TreeNode tmp = root.right;
                        root.right = new TreeNode(preorder[i]);
                        root = root.right;
                        root.right = tmp;
                        i++;
                    }
                }
            }

            while (root.val != inorder[j]) {
                root.left = new TreeNode(preorder[i]);
                root.left.right = root;
                root = root.left;
                i++;
            }
        }

        while (i - j > 1) {
            TreeNode tmp = root.right;
            root.right = null;
            root = tmp;
            i--;
        }

        return res;
    }
}
