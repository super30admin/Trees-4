// Time Complexity : O(Log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root){return null;}
        if(null == p && null == q){return root;}
        if(null == p){return q;}
        if(null == q){return p;}
        if(p.val > q.val){return lowestCommonAncestor(root,q,p);}
        if(root.val >= p.val && root.val <= q.val){return root;}
        if(root.val < p.val){return lowestCommonAncestor(root.right,q,p);}
        if(root.val > q.val){return lowestCommonAncestor(root.left,q,p);}
        return null;
    }
}