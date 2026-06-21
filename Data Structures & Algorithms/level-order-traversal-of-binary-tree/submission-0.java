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
    private int level = 0;
    private List<List<Integer>> values = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return values;

        if (values.size() == level) {
            values.add(new ArrayList<>());
        }

        values.get(level).add(root.val);
        level++;
        levelOrder(root.left);
        levelOrder(root.right);
        level--;
        return values;
    }

}
