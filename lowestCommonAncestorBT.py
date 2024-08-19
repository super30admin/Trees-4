# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Time Complexity: O(N), where N is the number of nodes in the tree.
        Space Complexity: O(h), where h is the height of the tree.
        """
        # Base case: if the current node is None, return None
        if not root:
            return None
        
        # If the current node is either p or q, return the current node
        if root == p or root == q:
            return root
        
        # Recur on the left and right subtrees
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # If both left and right are not None, it means p and q are found in
        # different subtrees, so the current node is the LCA
        if left and right:
            return root
        
        # If either left or right is not None, return the one that is not None
        return left if left else right
