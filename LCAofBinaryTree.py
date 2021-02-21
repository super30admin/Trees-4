# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Recursion. Base condition is if not root or root is p or root is q then return root
# We will recurse the left part until we find p or q. If we find both left and right then return root
# If we find only left then we will left and if we find only right then return right
# Else we dont find both then return Null

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode',
                             q: 'TreeNode') -> 'TreeNode':
        #base
        if not root or root == p or root == q:
            return root
        #logic
        left = self.lowestCommonAncestor(root.left, p, q)
        #stack.pop()
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        elif left:
            return left
        elif right:
            return right
        else:
            return None