// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        
        backtrack(root, p, path1);
        backtrack(root, q, path2);
        
        int i;
        for(i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        
        return path1.get(i - 1);
        
    }
    
    private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path) {
        
        if(root == null) return;
        
        path.add(root);
        if(root == p) {
            return;
        }
        
        backtrack(root.left, p, path);
        if(path.get(path.size() - 1) == p) {
            return;
        }
        backtrack(root.right, p, path);
        if(path.get(path.size() - 1) == p) {
            return;
        }
        
        path.remove(path.size() - 1);
    }
}