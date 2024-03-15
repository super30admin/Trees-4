//TC: O(n)
//SC: O(h)
class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.result=null;
        helper(root,p,q);
        return result;
        
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
        return ;
        if(p.val>root.val&&q.val>root.val)
        {
            helper(root.right,p,q);
        }
        else if(p.val<root.val&&q.val<root.val)
        {
            helper(root.left,p,q);

        }
        else
        {
            result=root;
            return;
        }
    }
}