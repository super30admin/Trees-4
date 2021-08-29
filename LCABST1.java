//Time complexity: O(log n)
//Space complexity: O(n)

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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        
        helper(root, p, q);
        return result;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return;
        }
        
        //both are larger so the LCA is in right subtree
        if(root.val < p.val && root.val < q.val)
            helper(root.right, p, q);
        
        //both are smaller so LCA is in left subtree
        else if(root.val > p.val && root.val > q.val){
            helper(root.left, p, q);
        }
        //root is the LCA
        else{
            result = root;
            return;
        }
            
    }
}