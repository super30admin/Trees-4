// Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take 2 lists to keep track of path of p and path of q. Keep an other path to keep track of visited elements. In helper. while root is
 * null return null, add root to path check if root is equal to p, if yes add path to pathP and add root also to pathP. Check if root is equal 
 * to q, if yes add path to pathQ and add root also to pathQ. After both left and right recursive calls remove the last element from path.
 * Iterate until the size of p path or q path and when you find a mismatch return number just before mismatch.
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
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathP = new ArrayList<>();
        this.pathQ = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());
        for(int i = 0; i<pathQ.size();i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;

    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        //logic
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);

        }
        if(root == q){
            pathQ= new ArrayList<>(path);
            pathQ.add(root);
        }
        
        helper(root.left, p, q, path);
        helper(root.right, p,q, path);
        //backtrack
        path.remove(path.size()-1);
    }
}