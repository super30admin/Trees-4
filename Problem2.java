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
    
    //Time Complexity : O(N) N - number of nodes in the BS tree
    //Space Complexity: O(N)
   /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
    */

    
    //Time Complexity : O(N)
    //Space Complexity: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        while(root != null) {
            if(root == p || root == q) return root;
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
    }
        return root;
    }
}
