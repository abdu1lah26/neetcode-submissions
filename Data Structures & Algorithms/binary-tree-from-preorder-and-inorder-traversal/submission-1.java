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
        Map<Integer, Integer> indexs = new HashMap<>();
        for(int i=0; i<preorder.length; i++) {
            indexs.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, inorder.length - 1, indexs);
    }

    public TreeNode dfs(int[] pre, int[] in, int start, int end, Map<Integer, Integer> indexs) {
        if(start > end) return null;

        int rootVal = pre[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int idx = indexs.get(rootVal);


        root.left = dfs(pre, in, start, idx-1, indexs);
        root.right = dfs(pre, in,  idx+1, end, indexs);

        return root;
    }
}
