// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    ArrayList<TreeNode> path1;
    ArrayList<TreeNode> path2;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null){
            return root;
        }
        helper(root, p, q, new ArrayList<>());
        for(int i=0;i<path1.size();i++){
            if(path1.get(i)!=path2.get(i)){
                return path1.get(i-1);
            }
        }
        return null;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> path){
        //base
        if(root==null){
            return;
        }
        
        //action
        path.add(root);
            
        //recursion
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        
        //for p
        if(p==root){
            path1 = new ArrayList<>(path);
            path1.add(root);
        } 
    
        //for q
        if(q==root){
            path2 = new ArrayList<>(path);
            path2.add(root);
        } 
        
        //backtrack
        path.remove(path.size()-1);
            
    }
}