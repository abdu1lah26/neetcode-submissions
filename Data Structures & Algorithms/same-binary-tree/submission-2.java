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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> qu = new LinkedList<>();
        qu.add(new TreeNode[]{p, q});

        while(!qu.isEmpty()) {
            TreeNode[] pair = qu.poll();
            TreeNode n1 = pair[0], n2 = pair[1];

            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null) return false;
            if(n1.val != n2.val) return false;

            qu.add(new TreeNode[]{n1.left, n2.left});
            qu.add(new TreeNode[]{n1.right, n2.right});
        }
        return true;
    }
}
