//Time complexity: O(N) //backtracking but since tree is already built it is not exp complexity
//space complexity: O(h)
//keep track of the path to p and q and then iterate until same first value hits

import java.util.*;

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
        if(root == null)
            return root;
        
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        
        backtrack(root, p, q, new ArrayList<>());
        
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                return path1.get(i - 1);
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
        path.add(root);
        backtrack(root.left, p, q, path); //recurse
        backtrack(root.right, p, q, path);
        path.remove(path.size() - 1); //backtracking
    }
}