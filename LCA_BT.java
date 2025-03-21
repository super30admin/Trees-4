// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Backtracking
 */
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
    ArrayList<TreeNode> pathp;
    ArrayList<TreeNode> pathq;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathp=new ArrayList<>();
        pathq=new ArrayList<>();
        backtrack(root,p,q,new ArrayList<>());
        for(int i=0;i<pathp.size();i++){
            if(pathp.get(i)!=pathq.get(i))
                return pathp.get(i-1);
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> path){
        if(root==null) return;
        path.add(root);
        if(root==p){
            pathp=new ArrayList<>(path);
            pathp.add(p);
        }
        if(root==q){
            pathq=new ArrayList<>(path);
            pathq.add(q);
        }
        backtrack(root.left,p,q,path);
        backtrack(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}