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
    int cnt, answer;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        // Recursive
        // cnt = k;
        // answer = -1;
        // inorder(root);
        // return answer;

        // Iterative
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    private void inorder(TreeNode root) {
        // base
        if(root == null || answer != -1) {
            return;
        }
        // logic
        inorder(root.left);
        cnt--;
        if(cnt == 0) {
            answer = root.val;
            return;
        }
        inorder(root.right);
    }
}
