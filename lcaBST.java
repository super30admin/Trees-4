// Time Complexity :O(n) - where n is the number of nodes in the tree
// Space Complexity : O(h-1) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Recutsive calls, Start from the root, if both values are smaller, call the function on the left. If both the values are greater, call the function on the right. Else return the root.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root==null) return null;
        //logic
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
}
}

// Time Complexity : O(n) - where n is the number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Iteratively while eoot is not null to Start from the root, if both values are smaller, go on the left. If both the values are greater, go on the right. Else return the root.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //logic
        while(root!=null){
        if(p.val<root.val && q.val<root.val)
           root=root.left;
        else if(p.val>root.val && q.val>root.val)
            root=root.right;
        else return root;
        }
        return null;
       
}
}