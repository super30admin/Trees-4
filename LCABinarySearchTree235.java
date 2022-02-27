// Time Complexity : O(h)
// Space Complexity : O(h)
//    where h : Height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Traverse the tree using following three conditions :- 
 *  1) If p and q are smaller than current node value then go to the left side of tree.
 *  2) If p and q are greater than current node value then go to the right side of tree.
 *  3) If both above conditions are not true then return current node.
 *



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
    if(root == null){
        return root;
    }
    lcf(root, p,q);
     return result;
    }

    void lcf(TreeNode root, TreeNode p , TreeNode q){
        if(root == null){
            return;
        }
        if(root.val >= p.val && root.val <= q.val){
            result = root;
            return;
        }
        if(root.val <= p.val && root.val >= q.val){
            result = root;
            return;
        }
        if(root.val < p.val && root.val < q.val){
            lcf(root.right, p, q);
        }
        else{
         lcf(root.left, p, q);
     }
    }
}
