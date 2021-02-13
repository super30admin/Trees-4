/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
time complexity: O(h), h is the height of tree
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //recursive method
        
        // if(root.val > p.val && root.val > q.val){
        //     //go left
        //     return lowestCommonAncestor(root.left,p,q);
        // }
        // else if(root.val < p.val && root.val < q.val){
        //     //go to right
        //     return lowestCommonAncestor(root.right,p,q);
        // }
        // else{
        //     return root;
        // }
        
        //iterative method
        while(root != null)
        {
            if(root.val > p.val && root.val > q.val){
                //go left
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        } 
        return null;
}
}