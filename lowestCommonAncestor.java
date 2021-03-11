// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root!=null) {
            
            if(p.val<=root.val && q.val>=root.val || p.val>=root.val && q.val<=root.val) {
                return root;
            }
            else if(p.val<root.val&&q.val<root.val) {
                root=root.left;
            } else {
                root=root.right;
            }
            
        }
        return null;
    }
}
