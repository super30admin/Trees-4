// Time Complexity :O(H)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root==null) return null;

        int curr= root.val;
        if(curr>p.val && curr>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(curr<p.val && curr<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}