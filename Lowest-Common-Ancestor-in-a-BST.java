
## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

//Approach : This problem can be solved in two ways:
1. Recursively
2. Iteratively



//Iteratively
// Time Complexity : O(h)
//Space Complexity : O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base condition
        if(root==null){
            return root;
        }
        while(root!=null){
            if(root.val==p.val || root.val==q.val){
                return root;
            }
            if((root.val>p.val && root.val<q.val)||(root.val<p.val && root.val>q.val)){
                return root;
            }
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
        return null;
    }
}

//Recursively:
//Time Complexity : O(h)
//Space Complexity : O(h)

class Solution {
    TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        recurse(root,p,q);
        return LCA;
    }
    private void recurse(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root==null){
            return;
        }
        if(root.val == p.val || root.val==q.val || (p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)){
            LCA=root;
            return;
        }

        if(p.val<root.val && q.val <root.val){
            recurse(root.left,p,q);
        }
        if(p.val>root.val && q.val >root.val){
            recurse(root.right,p,q);
        }
        


    }
}

//Other Way
class Solution {
    TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        recurse(root,p,q);
        return LCA;
    }
    private void recurse(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root==null){
            return;
        }

        if(p.val<root.val && q.val <root.val){
            recurse(root.left,p,q);
        }
        else if(p.val>root.val && q.val >root.val){
            recurse(root.right,p,q);
        }
        else{
            LCA=root;
            return;
        }
    }
}

//Other Way : In single function
class Solution {
    TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(p.val<root.val && q.val <root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val && q.val >root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
}
