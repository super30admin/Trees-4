# Approach:
# In a binary tree, the LCA of two nodes p and q is the deepest node that has both p and q as descendants.
# The problem can be solved recursively:
# 1. If the current node is None, return None.
# 2. If the current node matches either p or q, return the current node.
# 3. Recurse for the left and right subtrees.
# 4. If p and q are found in left and right subtrees respectively, the current node is the LCA.
# 5. Otherwise, return the non-null child.

# Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
# Space Complexity: O(H), where H is the height of the tree, for the recursion stack.
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
        # Base case: if the current node is None or matches p or q, return it
        if not root or root == p or root == q:
            return root
        
        # Recursively find LCA in the left subtree
        left = self.lowestCommonAncestor(root.left, p, q)
        # Recursively find LCA in the right subtree
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # If both left and right are non-null, the current node is the LCA
        if left and right:
            return root
        
        # Otherwise, return the non-null child (either left or right)
        return left if left else right
