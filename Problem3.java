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
LeetCode Submitted : yes
Time Complexity : O(Number of nodes)
Space Complexity : O(1)

The idea is to recursively traverse left and right subtree till we encounter any of the nodes p or q. if we encnounter both of the nodes then root node is the LCA. Else whichever node (LEFT/RIGHT) return not null will be the LCA
**/

class Solution {
    int flag = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
         if(root == null)
             return null;
        
        return findLCA(root,p,q);
    }
    
    private TreeNode findLCA(TreeNode root, TreeNode p,TreeNode q){
        if(root == null)
            return null;
        
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left  = findLCA(root.left,p,q);
        TreeNode right = findLCA(root.right,p,q);
        
        if(left != null && right != null)
            return root;
            
        if(left != null)
            return left;
        
        return right;
    }
}
