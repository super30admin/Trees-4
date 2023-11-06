class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        //st.pop();
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //st.pop();

        if(left == null && right == null) return null;
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return root;

    }
}

/**
 * First approach is, Maintaining path in a list and comparing both lists → whenever there is an uncommon the below value is the result.
To satisfy all the conditions and edge cases we add the fund value 2 times. (1 finishes first and other doesnt finish)
Optimized approach, Bottom up recursion → we will pass found targets to the children.   

 * 
 * 
 */