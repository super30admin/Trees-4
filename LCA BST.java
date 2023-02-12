/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Iterative
// Time Complexity = O(h)
// Space Complexity = (1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if (p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
    }
}


// Recursive
// Time Complexity = O(h)
// Space Complexity = O(h)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p,q);
        }
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p,q);
        }
        else{
            return root;
        }
    }
}
