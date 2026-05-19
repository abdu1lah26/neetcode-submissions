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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] pre, int[] in, int start, int end) {
        if(start > end) return null;

        int rootVal = pre[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int index = -1;
        for(int i=start; i<=end; i++) {
            if(in[i] == rootVal) {
                index = i;
                break;
            }
        } 

        root.left = dfs(pre, in, start, index-1);
        root.right = dfs(pre, in,  index+1, end);

        return root;
    }
}
