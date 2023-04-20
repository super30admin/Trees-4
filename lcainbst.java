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
        // check at every node if one node is greter than current nide and one is less than another given node, common ancestor lies between given two nodes
        // if root is greater than both the values, move left
        // recursive
        // TC-O(logN) 
        // SC-O(h) for stack
        // if(root.val > p.val && root.val>q.val){
        //     return lowestCommonAncestor(root.left,p,q);
        // }
        // // if root is less than both nodes, as both of them lie on same side, move right
        // else if(root.val<p.val && root.val < q.val){
        //     return lowestCommonAncestor(root.right,p,q);
        // }
        // else{
        //     return root;
        // }
        // iterative
        // TC-O(logN), SC-O(h)
        while(true){
            if(root.val > p.val && root.val>q.val){
            root=root.left;
        }
        // if root is less than both nodes, as both of them lie on same side, move right
        else if(root.val<p.val && root.val < q.val){
            root=root.right;
        }
        else{
            return root;
        }
        }
    }
}