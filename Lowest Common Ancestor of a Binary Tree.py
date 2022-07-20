""""// Time Complexity : O(n)
// Space Complexity : O(h) Recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left == None and right == None:
            return None
        if left != None and right == None:
            return left
        if left == None and right != None:
            return right

        else:
            return root

""""// Time Complexity : O(n)
// Space Complexity : O(n+n)~ O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if (root == None or root == p or root == q): return root
#
#         self.list1 = []
#         self.list2 = []
#
#         self.helper(root, p, q, [])
#
#         for i in range(len(self.list1)):
#             if (self.list1[i] != self.list2[i]):
#                 return self.list1[i - 1]
#
#     def helper(self, root, p, q, path):
#         # base
#         if (root == None):
#             return
#
#         # logic
#         path.append(root)
#         if (root == p):
#             self.list1 = path[:]
#             self.list1.append(p)
#         if (root == q):
#             self.list2 = path[:]
#             self.list2.append(q)
#
#         # backtrack
#         self.helper(root.left, p, q, path)
#         self.helper(root.right, p, q, path)
#
#         path.pop()
