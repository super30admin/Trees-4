//Here, we are using bottom-up recursion to check every node if the left child has a lca and right child has a lca and depending on both, we have conditions that return a treenode value.
//Time Complexity:O(n) where n is the number of nodes in the tree.
//Space Complexity:O(h) where h is the height of recursive stack space
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root == p || root == q){
            return root;
        }
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        } else if(left == null && right != null) {
            return right;
        } else if(left != null && right == null){
            return left;
        } else { // when both child nodes are p and q
            return root;
        }
    }    
}