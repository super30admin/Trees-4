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
    //tc - o(h)
    //sc -o(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val < p.val && root.val < q.val) 
        return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val)
        return lowestCommonAncestor(root.left, p, q);
        else
        return root;

    }
    //tc - o(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true)
        {
            if(root.val < p.val && root.val < q.val)
            root = root.right;
            else if (root.val > p.val && root.val > q.val)
            root = root.left;
            else
            return root;
        }
        
        

    }
}