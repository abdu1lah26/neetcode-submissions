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
    int cnt = 1;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int prevMax) {
        if(root == null) return 0;
        int cnt = 0;
        if(root.val >= prevMax)
        cnt = 1;

        cnt += dfs(root.left, Math.max(root.val, prevMax));
        cnt += dfs(root.right, Math.max(root.val, prevMax));

        return cnt;
    } 
}
