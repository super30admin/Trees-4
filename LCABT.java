// Time Complexity : O(max delth of the tree)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    private TreeNode p,q;
    private TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        this.ancestor=null;
        search(root);
        return ancestor;
        
        
    }
    private boolean search(TreeNode root)
    {
        if(root == null) return false;
        
       int left = search(root.left) ?1:0;
       int right = search(root.right)?1:0;
       int mid = (root==p || root ==q)?1:0;
      if (mid + left + right >= 2) {
            this.ancestor = root;
        }
        return (mid+left+right) >0;
        
       
           
    }
}