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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);//do?
        while (q.size() != 0) {
            TreeNode tmp = q.poll();
            if (tmp == null) {
                sb.append("null");
            }
            else {
                sb.append(tmp.val);
                q.add(tmp.left);
                q.add(tmp.right);
            }

            if (q.size() != 0) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        System.out.println(Arrays.toString(str));
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = !str[0].equals("null") ? new TreeNode(Integer.parseInt(str[0])) : null;
        q.add(root);
        int c = 1;

        for (int i = 1; i < str.length; i++) {
            if (c == 1) {
                TreeNode tmp = q.peek();
                if (!str[i].equals("null")) {
                    TreeNode l = new TreeNode(Integer.parseInt(str[i]));
                    tmp.left = l;
                    //System.out.println(l.val);
                    q.add(l);
                }
                c++;
            }
            else if (c == 2) {
                TreeNode tmp = q.poll();
                if (!str[i].equals("null")) {
                    TreeNode r = new TreeNode(Integer.parseInt(str[i]));
                    tmp.right = r;
                    //System.out.println(r.val);
                    q.add(r);
                }
                c = 1;
            }
            //System.out.println(root.left.val);
        }

        return root;
    }
} 