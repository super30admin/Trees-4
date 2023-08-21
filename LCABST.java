// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. If root is greater than both p and q, then LCA lies in left.
 * 2. If root is less than both p and q, then LCA lies in right.
 * 3. Else root is LCA.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val > p.val && root.val > q.val) root =  root.left;
            else if(root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
    }
}