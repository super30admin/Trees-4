//Time complexity : O(n) We might have to visit all the nodes
//Space complexity : O(h) Height of the tre
//Runs succesfully on leetcode
//No Problem

//Here we will be searching for the nodes in dfs, if the nodes are found, we'll be returning them
//If both the nodes are found at some node, that will be our lowest common ancestor

public class Trees_4_Problem_3_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p,  q);
        TreeNode right = lowestCommonAncestor(root.right,  p,  q);

        if(left != null && right != null) return root;
        if(left == null) return right;
        else return left;
    }
}
