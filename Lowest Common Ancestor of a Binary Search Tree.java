/*
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root



# Iterative
class Solution:
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    if root is None:
        return None
    while root is not None:
        
        if p.val < root.val and q.val < root.val:
            root = root.left
        elif p.val > root.val and q.val > root.val:
            root = root.right
        else:
            return root
    return None
*/
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        
        else
            return root;
    }
}
*/

// Time - O(h) where h is height
// Space - O(1) 
// Logic - Just used bst property and travelled accordingly
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        while (root != null){
            if (p.val < root.val && q.val < root.val)
                root = root.left;
        
            else if (p.val > root.val && q.val > root.val)
                root = root.right;

            else
                return root;
        }
        return null;
    }
}