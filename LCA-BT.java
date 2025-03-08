
class Solution {
    
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return root;
        }
       
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        
        dfs(root, p, q, new ArrayList<>());
        
        for (int i = 0; i < pathP.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }
        return null;
    }

   
    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
      
        if (root == null || (pathP.size() > 0 && pathQ.size() > 0)) {
            return;
        }
       
        path.add(root);
        
        if (root == p) {
            pathP = new ArrayList<>(path);
            
            pathP.add(p);
        }
        if (root == q) {
            pathQ = new ArrayList<>(path);
           
            pathQ.add(q);
        }
        
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
       
        path.remove(path.size() - 1);
    }
}

// Bottom-up recursion approach:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(H) - height of the tree - recursive stack space, pathP
// and pathQ space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || root == p || root == q) {
            return root;
        }
         TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
     
        if (left == null && right == null) {
            return null;
        }
        
        else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        }
       
        else {
            return root;
        }
    }
}