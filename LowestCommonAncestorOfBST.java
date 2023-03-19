// recusrive
public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        else if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
}

// TC - O(h)
// SC - O(h)

// iterative
public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val<p.val && root.val<q.val) root = root.right;
            else if(root.val>p.val && root.val>q.val) root = root.left;
            else return root;
        }
    }
}

// TC - O(h)
// SC - O(1)