// Time Complexity :O(h)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class LCABst {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || p==null || q==null){
          return null;
      }

      if(p.val < root.val && q.val < root.val){
          return lowestCommonAncestor(root.left,p,q);
      }else if(p.val > root.val && q.val > root.val){
          return lowestCommonAncestor(root.right,p,q);
      }else {
          return root;
      }
    }
}
