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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();

        st.push(new Pair<>(root, 1));
        int level = 0;
        while(!st.isEmpty()) {
            Pair<TreeNode, Integer> curr = st.pop();
            TreeNode node = curr.getKey();
            int depth = curr.getValue();

            if(node != null) {
                level = Math.max(level, depth);
                st.push(new Pair<>(node.left, depth+1));
                st.push(new Pair<>(node.right, depth+1));
            }
        }
        return level;
    }
}
