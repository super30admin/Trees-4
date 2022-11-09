/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time: O(h)
//Space: O(h)
//Recursion
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null)
//             return root;
//         if(root.val > p.val && root.val > q.val)
//             return lowestCommonAncestor(root.left, p, q);
//         else if(root.val < p.val && root.val < q.val)
//             return lowestCommonAncestor(root.right, p, q);
//         else
//             return root;
        
        
//     }
// }

//Time: O(n)
//Space: O(1)
//Iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        while(true){
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        
    }
}
