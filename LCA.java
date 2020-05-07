// Time Complexity : O(max delth of the tree)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while(root!=null)
    {
    if(p.val>root.val && q.val>root.val)
         root = root.right;
    else if(p.val<root.val && q.val<root.val)
        root = root.left;
    else
        return root;
    }
        return null;
    }
}