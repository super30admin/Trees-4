/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - height of recursive stack */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //Top-down recursion
class Solution {
    private List<TreeNode> pathP;
    private List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root, p, q, new ArrayList<>());
        for(int i = 0; i < pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base condition
        if(root == null) return;
        //action
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        //recurse
        if(pathP == null || pathQ == null)
            helper(root.left, p, q, path);
        if(pathP == null || pathQ == null)
            helper(root.right, p, q, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}