// Time Complexity : O(n) where n is no of nodes since we can traverse the entire tree to find them.
// Space Complexity : O(h) where h is the height of the tree for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class LCAofBT {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        helper(root, p, q, new ArrayList<TreeNode>());
        //The moment there is a difference in path, the prev node is the common ancestor
        for(int i=0;i<pathP.size();i++){
            if(pathP.get(i)!=pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root==null) return;
        //action
        path.add(root);
        if(root==p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root==q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        //logic
        //recurse
        helper(root.right,p,q,path);
        helper(root.left,p,q,path);
        //backtrack
        path.remove(path.size()-1);
    }
}