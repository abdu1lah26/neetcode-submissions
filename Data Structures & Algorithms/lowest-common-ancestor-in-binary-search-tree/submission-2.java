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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = root;

        while(tmp != null) {
            if(Math.min(p.val, q.val) > tmp.val)
            tmp = tmp.right;

            else if(Math.max(p.val, q.val) < tmp.val)
            tmp = tmp.left;

            else
            return tmp;
        }

        return null;         
    }
}
