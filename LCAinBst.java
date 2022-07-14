//Time complexity : O(logn)
//Space Complexity : O(n)
//Did it run on leetcode : yes

public class LCA_In_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p,q);
        else if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p,q);
        else return root;
    }

    //iterative solution
    public TreeNode lowestCommonAncestor_Iteratively(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if(p.val > root.val && q.val > root.val) root = root.right;
            else if(p.val < root.val && q.val < root.val) root = root.left;
            else return root;
        }
    }}