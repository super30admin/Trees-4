
// Time - O(N)
// Space - O(1)


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) return root;

        root.left = lowestCommonAncestor(root.left, p, q); // go to the left child and run dfs
        root.right = lowestCommonAncestor(root.right, p, q); // go to the right child and run dfs

        if(root.left != null && root.right != null) return root; // if we found both left and right child as not null return the root element
        else if(root.left != null) return root.left; // if we find only left child and right child null return left child
        else if(root.right != null) return root.right; // if we find only right child and left child null return right child
        else return null;


    }
}