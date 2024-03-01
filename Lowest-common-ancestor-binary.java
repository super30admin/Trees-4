// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using two paths, storing the paths in two different path by backtracking and comparing
// them to see if they are unequal and return the prev element as LCA.

// 236. Lowest Common Ancestor of a Binary Tree


class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q,new ArrayList<>());
        // copying the last elements in p and q
        pathP.add(p);
        pathQ.add(q);
        for(int i=0;i<pathP.size();i++){
            TreeNode currP = pathP.get(i);
            TreeNode currQ = pathQ.get(i);
            if(currP != currQ){
                return pathP.get(i-1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        // base
        if(root == null) return;
        // logic
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
        }
        // recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        // backtrack
        path.remove(path.size()-1);
    }
}