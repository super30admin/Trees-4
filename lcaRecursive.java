//time complexity O(n) because in case of a skewed tree we have to visit each and every node
//space complexity O(n) and the same case as above the space used by recursive stack will be to store n nodes

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
        //base
        if(root == null) return null;
        //logic
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p,q);
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p,q);
        else return root;
    }
}
