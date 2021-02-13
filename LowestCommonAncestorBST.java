/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorBST {
    /*
      Time : O(N) | N being number of nodes in a tree
      Space : O(H) | H - height of a tree, maximuam we traverse through all levels
      LeetCode : YES
     */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        
        int pVal = p.val;
        int qVal = q.val;
        int rVal = root.val;
        if(pVal > rVal && qVal > rVal){
            return lowestCommonAncestor(root.right,p, q);
        }else if( pVal < rVal && qVal < rVal){
            return lowestCommonAncestor(root.left ,p, q);
        }else{
            return root;
        }
        
    }
}
