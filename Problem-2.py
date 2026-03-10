# Time Complexity : O(n), n = number of nodes
# Space Complexity : O(h), h = height of tree (recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Traverse the tree recursively.
# 2. If root is p or q, return root.
# 3. If p and q are found in different subtrees, root is their LCA.
# 4. Otherwise, propagate non-null child up.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left and right:
            return root
        return left or right