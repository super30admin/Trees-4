/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(h+n), where h is the height of the tree and n is the total no of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new ArrayList<>());
        TreeNode lca = null;
        for(int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if(pathP.get(i).val == pathQ.get(i).val) {
                lca = pathP.get(i);
            }
        }
        return lca;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if(root == null) return;

        if(root.val == p.val) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
            pathP.add(p);
        }

        if(root.val == q.val) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
            pathQ.add(q);
        }

        path.add(root);
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        path.remove(path.size()-1);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val) return root;
        if(root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else if(left == null && right == null) return null;
        else return root;
    }
}