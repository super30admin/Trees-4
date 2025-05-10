//TC:SC:O(H)

import javax.swing.tree.TreeNode;

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
        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left, p, q);
        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}


// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         while(true){
//                 if(p.val<root.val && q.val<root.val) return root = root.left;
//                 else if(p.val>root.val && q.val>root.val) return root = root.right;
//                 else return root;
//         }
//     }
// }