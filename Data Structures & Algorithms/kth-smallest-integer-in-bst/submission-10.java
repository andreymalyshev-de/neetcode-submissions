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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode tmp = root.left;

            while (root != null) {
                tmp = root.left;

                if (tmp == null) {
                    k--;
                    if (k == 0) return root.val;
                    root = root.right;
                }

                else {

                    while (tmp.right != null && tmp.right != root) {
                        tmp = tmp.right;
                    }

                    if (tmp.right == null) {
                        tmp.right = root;
                        root = root.left;
                    } 
                    
                    else if (tmp.right == root) {
                        k--;
                        if (k == 0) return root.val;
                        tmp.right = null;
                        root = root.right;
                    }
                }
            }

        return -1;
    }
}
