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
    public boolean isCousins(TreeNode root, int x, int y) {
        // T.C: O(n)
        // S.C: O(n)
        if (root == null || x == y)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x) {
                    x_found = true;
                }
                if (curr.val == y) {
                    y_found = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if (curr.left != null) 
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            if (x_found == true && y_found == true)
                return true;
            if (x_found == true || y_found == true)
                return false;
        }
        return false;
    }
}