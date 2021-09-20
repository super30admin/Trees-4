//236. Lowest Common Ancestor of a Binary Tree: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Time Complexity : O(N)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
    List<TreeNode> path1, path2;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        
        backtrack(root, p, q, new ArrayList<>());
        
        //when path1[i] != path2[i], return path1[i-1]
        for(int i=0; i<path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                return path1.get(i-1);
            }
        }
        
        return root;
    }
    
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        
        //base
        if(root == null) return;
        
        if(root == p){
            path1 = new ArrayList<>(path);
            path1.add(p);
            path1.add(p);
        }
        
        if(root == q){
            path2 = new ArrayList<>(path);
            path2.add(q);
            path2.add(q);
        }
        
        //logic
        path.add(root); //action
        backtrack(root.left, p, q, path); //recurse
        backtrack(root.right, p, q, path);
        path.remove(path.size()-1); //backtracking
        
    }
}