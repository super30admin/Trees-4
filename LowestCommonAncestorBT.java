//TC: O(k) where k is the max depth of p or q
//SC: O(1)
public class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root.val==p.val){
            return p;
        }

        if (root.val==q.val){
            return q;
        }
    
        TreeNode rootLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode rootRight = lowestCommonAncestor(root.right,p,q);

        if (rootLeft!=null && rootRight!=null){
            return root;
        }
        else if(rootLeft!=null && rootRight==null){
            return rootLeft;
        }
        else if(rootLeft==null && rootRight!=null){
            return rootRight;
        }
        else{
            return  null;
        }
    }
}