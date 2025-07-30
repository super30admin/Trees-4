/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// recursive using property of BST
// TC = O(h), height of the tree
// SC = O(h), recursive stack = height of tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        } else if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        } else {
            return root;
        }
    }
}

// //Iterative
// //TC = O(h)
// //SC = O(1)
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null) return null;
//         while(root != null){
//             if(root.val > p.val && root.val > q.val){
//                 root = root.left;
//             } else if(root.val < p.val && root.val < q.val){
//                 root = root.right;
//             } else {
//                 return root;
//             }
//         }
//         return null;
//     }
// }