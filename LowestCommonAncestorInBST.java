public class LowestCommonAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        TC:O(h) //logn
//        SC:O(h)
        if(root==null) return null;
        if(p.val<root.val&&q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else
            return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
//        TC:O(h) //logn
//        SC:O(1)
        if(root==null) return null;
        while(true){
            if(p.val<root.val&&q.val<root.val) {
                root = root.left;
            }
            else if(p.val>root.val&&q.val>root.val){
                root = root.right;
            }
            else
                return root;
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
