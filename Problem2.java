// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//236. Lowest Common Ancestor of a Binary Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
    // DFS solution, BOTTOM UP
    // time: O(n)
    // space: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        // base
        if (root == null || root == p || root == q)
            return root;

        // logic
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return root;

    }
}

/*
class Solution {
    //DFS solution TOP DOWN
    //time: O(n)
    //space: O(h)
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    List<TreeNode> list;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        
        TreeNode result = null;
        
        //do dfs and get the paths
        helper(root, p, q, new ArrayList<>());
        
        //iterate over the paths and find lca
        int i = 0;
        while(true){
            if(pathP.get(i) != pathQ.get(i)){
                result = pathP.get(i-1);  
                break;
            }else{
                i++;
            }
        }
        
        return result;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list){
        //base
        if(root == null) return;
        
        //logic
        //action
        list.add(root);
        if(root == p){
            pathP.addAll(new ArrayList<>(list));
            pathP.add(p);
        }
        if(root == q){
            pathQ.addAll(new ArrayList<>(list));
            pathQ.add(q);
        }
        
        //recurse
        helper(root.left, p, q, list);
        helper(root.right, p, q, list);
        
        //backtrack
        list.remove(list.size()-1);
    }
    
}
*/