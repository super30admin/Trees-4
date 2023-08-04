public class LowestCommonAncestorBST {
    //Time complexity: O(N)
    //Space Complexity: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        if(root.val< p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        else if(root.val> p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;


    }
}
