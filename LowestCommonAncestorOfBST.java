/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**

This code iteratively finds the lowest common ancestor (LCA) of nodes p and q in a binary search tree (BST).
 It starts traversing the BST from the root, moving left or right based on the values of p and q compared to the current root. When p and q are on different sides of the current root, it means the current root is the LCA.
 Finally, it returns the LCA found during the traversal. 
 Time Complexity: O(H),
 Space - O(1)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        while(true){
            if(p.val<root.val && q.val<root.val){
                root = root.left;

            }
            else if(p.val>root.val && q.val>root.val){
                root = root.right;
            }
            else{
                res = root;
                break;
            } 
        }
        return res;
    }
}
