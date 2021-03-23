# Time Complexity : O(n) where n is number of elements in tree
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Tree-4
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if root:
            # If root itself is p or q then return the root
            if root == p or root == q:
                return root
            # Find the left and right child
            left = self.lowestCommonAncestor(root.left, p, q)
            right = self.lowestCommonAncestor(root.right, p, q)

            # if the left or right is either p or q then return it
            if left and right:
                return root
            elif left:
                return left
            elif right:
                return right

        # if root is none then return none
        return None