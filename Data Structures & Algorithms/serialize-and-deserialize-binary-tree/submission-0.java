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
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);

        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] idx = {0};

        return dfsDeserialize(nodes, idx);
    } 

    public TreeNode dfsDeserialize(String[] nodes, int[] idx) {
        if(nodes[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;
        root.left = dfsDeserialize(nodes, idx);
        root.right = dfsDeserialize(nodes, idx);

        return root;
    }
}
