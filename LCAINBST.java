/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time complexity - O(log n)
// Space complexity - O(n)
//Solved on leetcod e- yes
// faced any issues - No
// If the one of the value is less than root and other is greater than the root, then root will be th common anscetor.
// if both are greater than root, we are traversing towards left
// Else we are traversing towards right
class Solution {
    TreeNode l=null,r=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val <=root.val && q.val>=root.val) || (q.val<=root.val && p.val>=root.val)) return root;
        if(p.val<root.val && q.val<root.val) 
        l = lowestCommonAncestor(root.left,p,q);
        if(p.val>root.val && q.val>root.val) 
        r = lowestCommonAncestor(root.right,p,q);
        
        if(l!=null) return l;
        if(r!=null) return r;
        return null;
    }
}
