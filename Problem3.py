"""
I implemented this by first checking if the current root is either p or q —
in that case, I return the root. Then I recursively search both left and right
subtrees. If both return non-null, the current root is the LCA. If only one side 
returns a non-null node, that is the LCA.
Time Complexity: O(N)
Space Complexity: O(1)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        
        if root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is not None and right is not None:
            return root
        elif left is not None:
            return left
        else:
            return right