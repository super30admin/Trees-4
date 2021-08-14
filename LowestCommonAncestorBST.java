// Time Complexity : o(n)
// Space Complexity : 0(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        if(root==null)
            return root;
        
        //iterative
        /*
        while(true)
        {
             if(p.val<root.val && q.val<root.val)
               root=root.left;
        
            else if(p.val>root.val && q.val>root.val)
                 root=root.right;
            
            else
            {
                return root;
            }
        }
        */
        
        // recursive
        helper(root,p,q);
        return result;
    }
    // Recursive 
    private void helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
            return;
        
        //logic
        if(p.val<root.val && q.val<root.val)
            helper(root.left,p,q);
        
        else if(p.val>root.val && q.val>root.val)
            helper(root.right,p,q);
        else
        {
            result=root;
            return;
        }
        
    }
    
    
}
