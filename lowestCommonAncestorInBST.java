// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/* 
Traverse the BST and check root's left if the search node's values are lower, check right is greater.
*/


public class lowestCommonAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        while(root != null) {
            int rootVal = root.val;
            if(p.val > root.val && q.val > root.val) 
                root = root.right;
            else if (p.val < root.val && q.val < root.val) 
                root = root.left;
            else
                return root;
        }
        
        return null;
    }
}
