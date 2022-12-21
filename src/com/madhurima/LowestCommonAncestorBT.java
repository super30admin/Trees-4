// Time Complexity : O(n) visiting all the nodes
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes


package com.madhurima;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBT {
}

class SolutionTopDownRecursion {

    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    //top down recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();

        dfs(root, p, q, new ArrayList<>());

        for(int i = 0; i < pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }

        return null;

    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null){
            return;
        }

        //logic
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }else if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);

        path.remove(path.size() - 1); //its a leaf node, nothing is ahead of this, can't be in the path

    }

}

class SolutionBottomUpRecursion {

    //bottom up recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }
        else if(left != null && right == null){
            return left;
        }else if(left == null && right != null){
            return right;
        }else{
            return root;
        }
    }
}
