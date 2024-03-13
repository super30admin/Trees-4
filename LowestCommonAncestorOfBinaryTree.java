
/**This approach ensures that the algorithm explores all nodes in the binary tree exactly once, resulting in a time complexity of O(N), where N is the number of nodes in the tree. The space complexity is also O(N) due to the recursion stack, where N is the height of the binary tree in the worst case (unbalanced tree).
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
//recurse
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

 //bactrack  
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}
