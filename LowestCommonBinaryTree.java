/** Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
* Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
* Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val)
        {
            helper(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) 
        {
            helper(root.right, p, q);
        }
        else 
        {
            return root;
        }
        
        return null;
    }
}
