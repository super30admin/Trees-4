/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC - O(n), SC - O(1)
// LC - 235

// If current root val is less than p val and root val less than q val, we need to go to right side of tree and search there.
// If current root val is greater than p val and root val greater than q val, we need to go to right side of tree and search there.
// Else root val is in between p and q and we return root
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else{
                return root;
            }
        }
        return null;
    }
}

// Recursive approach

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)){
//             return root;
//         }
//         else if(p.val == root.val || q.val == root.val){
//             return root;
//         }
//         else if(root.val < p.val && root.val < q.val){
//             return lowestCommonAncestor(root.right, p, q);
//         }
//         else {
//             return lowestCommonAncestor(root.left, p, q);
//         }
//     }
// }