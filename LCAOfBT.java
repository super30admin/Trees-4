//TC = O(N)
//SC = O(h)

public class LCAOfBT {
    

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) return root;
        
        TreeNode left =lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left == null && right == null) return null;
        
        else if(left == null && right!=null) return right;
        
        else if(left!=null && right == null) return left;
        
        else return root;
    }
    public static void main(String args[])
    {
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);

        three.left=five;
        three.right=one;

        five.left=six;
        five.right=one;

        one.left = zero;
        one.right=eight;

        TreeNode ans = lowestCommonAncestor(three, six, zero);
        System.out.println(ans.val);
    }
}
