// Time Complexity : O(height of tree) -> not visiting all the nodes
// Space Complexity : O(height of tree) in case of recursion and O(1) in case of iterative approach
// Did this code successfully run on Leetcode : yes

package com.madhurima;

public class LowestCommonAncestorBST {
}

class SolutionBSTRecursive {
    //recursive approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
}


class SolutionBSTIterative {

    //iterative approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }

    }
}