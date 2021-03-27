/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * TC: O(n) traversing all nodes
 * SC: O(n) recursive stack space + storing paths from node to p and q
 * Approach: Get the paths from root to p and q => LCA is the node from which the two paths start to diverge
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        
        backtrack(root, p, path1);
        backtrack(root, q, path2);
        
        int i = 0;
        
        // loop to find the node from which oaths diverge
        while(i < Math.min(path1.size(), path2.size())) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
            
            i++;
        }
              
        return path1.get(i - 1);
    }
    
    private void backtrack(TreeNode root, TreeNode x, List<TreeNode> path) {
        
        if(root == null) {
            return;
        }
        
        path.add(root);
        
        // comapre nodes directly, works even if the tree contains nodes with duplicate values 
        if(root == x) {
            return;
        }
        
        backtrack(root.left, x, path);
        
        // optimization to stop recursion if we have found a node and we do not need to look further
        if(path.get(path.size() - 1) == x) {
            return;
        }
             
        backtrack(root.right, x, path);
        
        // optimization to stop recursion if we have found a node and we do not need to look further
        if(path.get(path.size() - 1) == x) {
            return;
        }
        
        // backtrack
        if(path.get(path.size() - 1) != x) {
            path.remove(path.size() - 1);
        }
    }
}


/**
 * TC: O(n)
 * SC: O(n)
 * Approach: Look for nodes in the left and right subtree. If two nodes are found in different subtrees then return current root -> LCA
 *          Or return the node if it was found
 *          Or return null if the node was not found
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base condition
        if(root == null || root == p || root == q) {
            return root;
        }
        
        // look in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        
        // look in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if p and q are found in the left and right subtrees then current root is LCA
        if(left!= null && right != null) {
            return root;
        }
        // if a node (p or q) is found in the left subtree then return that node
        else if(left != null) {
            return left;
        }
        // if a node (p or q) is found in the right subtree then return that node
        else if(right != null) {
            return right;
        }
        
        // if no node wad found in any of the subtrees then return null
        return null; 
    }
}
