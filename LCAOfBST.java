//TC = O(n)
//SC = O(h)

public class LCAOfBST {
    
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root.val>p.val && root.val>q.val)
        {
            return lca(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val)
        {
            return lca(root.right,p,q);
        }
        else
        {
            return root;
        }
    }

    public static void main(String args[])
    {
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);

        six.left=two;
        six.right=eight;

        two.left=zero;
        two.right=four;

        eight.left=seven;
        eight.right=nine;

        four.left=three;
        four.right=five;

        TreeNode ans = lca(six, two, eight);
        System.out.println(ans.val);
        
    }
}
