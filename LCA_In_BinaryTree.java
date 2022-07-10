//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

public class LCA_In_BinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root == p || root == q) return root;

        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return root;
    }

}
