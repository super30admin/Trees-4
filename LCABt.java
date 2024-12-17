// Time Complexity :O(h)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class LCABt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     if(root == null || root == p || root == q) return root;

      TreeNode left = lowestCommonAncestor(root.left,p,q);
      TreeNode right = lowestCommonAncestor(root.right,p,q);

      if(left == null && right == null) return null;
      else if(left !=null && right == null) return left;
      else if(left == null && right != null) return right;
      else return root;

    }
}
