import java.util.List;

/*
## Problem 3: Lowest Common Ancestor of a Binary Tree 
(https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

Time Complexity :   O (n) 
Space Complexity :  O (h) 
Did this code successfully run on Leetcode :    Yes (236. Lowest Common Ancestor of a Binary Tree)
Any problem you faced while coding this :       No
 */
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
    
class Solution {
    // create 2 path for p and q
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        helper(root, p, q, new ArrayList<>());
        
        // look for common path, return prev node when match not found
        for(int i=0; i< pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i -1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> path){
        // base
        if(root == null)
            return;
        
        // logic
        // action
        path.add(root);
        // when p found, make deep copy of path and add into pathP
        if( root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        // when q found, make deep copy of path and add into pathQ
        if( root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        
        // recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        
        // backtrack
        path.remove(path.size() -1);
    }
}