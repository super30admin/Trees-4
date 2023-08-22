
 // Time Complexity : O(h) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will look for a root node which has both p and q on two different sides. If they are on the same side, then we keep moving forward until 
// we find a node which lies between the two numbers. 

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //check if both the elements are on the left sides
        if(root.val>p.val && root.val>q.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        //check if they are on the right sides
        else if(root.val<p.val && root.val<q.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        //else if they are on two different sides or p is the child of q or vice versa, then the root is the ancestor
        else
        {
            return root;
        }
        
    }
}