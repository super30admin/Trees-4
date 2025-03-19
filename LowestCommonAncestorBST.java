
//iterative TC-O(n) space O(1)
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }

        }

        return new TreeNode(0);
    }



 public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
 }
}
/*
//recursive TC-O(N) space O(h)
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }

* */