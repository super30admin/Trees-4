/*
 Approach 1
 Recursive - Path Finding Algo using BST properties
           - if we are at point where p and q are left and right respectively, root is the
           lca
           - if we reach at any given node p or q then that is the lca
 Time Complexity - O(H)
 Space Complexity - O(H)

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class LowestCommonAncestorOfBinarySearchTree_LC_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val) { //root bigger than p and q move to left
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) { //root less than p and q, move right
            return lowestCommonAncestor(root.right, p, q);
        } else return root;
    }
}
/*
Approach 2
 Iterative - Path Finding Algo using BST properties
           - if we are at point where p and q are left and right respectively, root is the
           lca
           - if we reach at any given node p or q then that is the lca

 Time Complexity - O(H)
 Space Complexity - O(H)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else if(curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            }
            else return curr;
        }
        return null;
    }
} */