# Time Complexity : O(h)
# Space Complexity:o(h)
#  Did this code successfully run on Leetcode : Yes
# Approach 1:recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return root

        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)

        elif root.val < q.val and root.val < p.val:
            return self.lowestCommonAncestor(root.right, p, q)

        else:
            return root


# Time Complexity : O(h)
# Space Complexity:o(1)

# Approach 2: Iterative
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return root

        while True:
            if root.val > p.val and root.val > q.val:
                root = root.left

            elif root.val < q.val and root.val < p.val:
                root = root.right

            else:
                return root

