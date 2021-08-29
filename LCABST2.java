//Time complexity: O(log N)
//space complexity: O(h)
//recursive approach
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
        if(root == null)
            return root;
        
        //if both values are smaller than the root then they have a common ancestor on the left
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        //if both values are larger then they have common ancestor to the right
        else if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        //if one is smaller and one is greater then root is the lowest common one
        else
            return root;
    }
    
 
}