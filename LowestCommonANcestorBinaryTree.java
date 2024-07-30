// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorBinaryTree {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathP = new ArrayList<>();
        this.pathQ = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());
        for(int i = 0; i < pathP.size(); i++) {
            if(pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }
        return null;    
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base case
        if(root == null) return;

        //logic
        //action
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        //recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);

        //backtrack
        path.remove(path.size()-1);
    }
}