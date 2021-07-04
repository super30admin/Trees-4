import java.util.*;
class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class LCABT {
    TreeNode result = null;
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null) return null;
       
        helper(root, p, q);         
        return result;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;


        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if(left + right + mid >= 2) {
            result = root;
            System.out.println(root.val);
        }

        return (left+right+mid) > 0; 
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println("LCA BT");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LCABT obj = new LCABT();
        System.out.println(obj.lowestCommonAncestor(root, root.left.right.right, root.right.right).val);
    }
}