# Approach:
# In a BST, for any node:
# 1. If both p and q are smaller than the current node, the LCA lies in the left subtree.
# 2. If both p and q are greater than the current node, the LCA lies in the right subtree.
# 3. Otherwise, the current node is the LCA as it is the lowest node where p and q split.
# This allows us to solve the problem using recursion or iteration.

# Time Complexity: O(H), where H is the height of the tree. In the worst case, it could be O(n) for a skewed tree.
# Space Complexity: O(H), for the recursion stack. In the iterative approach, it's O(1).
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Start traversing the BST
        while root:
            # If both p and q are smaller, move to the left subtree
            if p.val < root.val and q.val < root.val:
                root = root.left
            # If both p and q are greater, move to the right subtree
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                # Found the split point where p and q diverge, return root
                return root
