// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

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
        //base
        if(root == null || root == p || root == q) return root;
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return root;
    }
}

/*
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());
        for(int i = 0; i < pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i - 1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        //logic
        //action

        //recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}
*/