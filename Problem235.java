class Problem235 {
//TC=O(n)
//SC=O(1)
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val<root.val && q.val<root.val)
                root=root.left;
            else if(p.val>root.val && q.val>root.val)
                root=root.right;
            else
                return root;
        }
    }
//TC=O(n)
//SC=O(h)
  public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestorRecursion(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestorRecursion(root.right,p,q);
        else
            return root;
    }
}
