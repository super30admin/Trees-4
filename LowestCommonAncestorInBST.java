// Time Complexity : O(logn)
// Space Complexity : O(logn)
public class LowestCommonAncestorInBST {
    TreeNode lowestCommonAncestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       dfs(root,p,q);
        return lowestCommonAncestor;
    }
    
    public void dfs(TreeNode root,TreeNode p, TreeNode q)
    {
        //base
        if(root == null)
            return;
        //logic
        if(lowestCommonAncestor==null && root.val>p.val && root.val>q.val)
            dfs(root.left,p,q);
        else if(lowestCommonAncestor==null && root.val<p.val && root.val<q.val)
            dfs(root.right,p,q);
        else if(lowestCommonAncestor==null)lowestCommonAncestor = root;
        
    }
}
