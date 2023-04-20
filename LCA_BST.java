/**
 * Time Complexity - O(H) where H is the height of the BST.
 * Space Complexity - O(H)
 * In the case of skewed tree, H is equal to N where N is the number of nodes in the tree.
 * In a perfectly balanced tree, H is equal to log N.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

/**
 * Time Complexity - O(H) where H is the height of the BST.
 * Space Complexity - O(1)
 * In the case of skewed tree, H is equal to N where N is the number of nodes in the tree.
 * In a perfectly balanced tree, H is equal to log N.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr = root;
        int pVal = p.val, qVal = q.val; 
        while(ptr != null) {
            if(pVal < root.val && qVal < root.val)
                root = root.left;
            else if(pVal > root.val && qVal > root.val)
                root = root.right;
            else 
                return root;
        }
        return null;
    }
}
