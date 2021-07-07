TC: O(n)
SC: O(n)

Runtime: 5 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
Memory Usage: 35 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

Approach: We will search for p and q by traversing every node. If we find the node, we will return the node to its parent.
The lowest common ancestor will be the one which has left and right node as not null. We will return that node.


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        if(root == p || root == q){
            return root;
        }
        
        
        TreeNode left =lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left == null && right!= null) return right;
        else if(left != null && right== null) return left;
        else if(left == null && right == null) return null;
        else return root;
        
    }
}
