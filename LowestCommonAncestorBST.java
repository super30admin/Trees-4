//Time Complexity: O(logN);
//Space Complexity: O(1);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode l, TreeNode r) {
        if(root==null){
            return null;
        }
        if(root.val>=l.val && root.val<=r.val){
            return root;
        }
        if(root.val>l.val && root.val>r.val){
            return lowestCommonAncestor(root.left,l,r);
        }
        if(root.val<l.val && root.val<r.val){
            return  lowestCommonAncestor(root.right,l,r);
        }
        return root;

    }
}