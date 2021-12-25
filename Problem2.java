//time o(n)
//space o(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(p.val < q.val) {
           return helper(root, p,q);
       } else {
           return helper(root, q,p);
       }
    }
    
    private TreeNode helper(TreeNode root, TreeNode v1, TreeNode v2) {
        if(root == null) {
            return null;
        }
        if(root.val == v1.val || root.val == v2.val) {
            return root;
        } else if(v1.val < root.val && v2.val > root.val) {
            return root;
        } else if(v1.val > root.val && v2.val > root.val) {
            return helper(root.right, v1,v2);
        } else if(v1.val < root.val && v2.val < root.val) {
            return helper(root.left, v1,v2);
        }
        return null;
    }
}
