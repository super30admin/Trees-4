# Time Complexity : O(n), n = number of nodes
# Space Complexity : O(h), h = height of the tree (recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Traverse the tree recursively to find p and q.
# 2. If root is None or matches p or q, return root.
# 3. Recursively check left and right subtrees.
# 4. If both left and right are non-null, root is the LCA.
# 5. Otherwise, return the non-null child (propagating found node up).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        if not root or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left and right:
            return root
        
        return left if left else right