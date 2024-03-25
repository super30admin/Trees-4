// Time Complexity : O(h), h = log n in complete binary tree.
// Space Complexity : O(h),  recursive stack space
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : if p and q lies on opposite side of the root or we find either p or q, that is LCA.

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
        if( root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if( root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
        
    }
}

//Iterative solution
// Time Complexity : O(log n)
// Space Complexity : O(1)
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Keep iterating over the tree until we find the LCA
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
        
        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }

    }
}