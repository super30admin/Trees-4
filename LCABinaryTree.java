// Time Complexity : O(log n) where n is the number of elements in the tree
// Space Complexity : O(log n) where n is the number of elements in the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class LCABinaryTree {
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || node ==p || node ==q){
            return node;
        }

        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return node;
        }
    }
}
