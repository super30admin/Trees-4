'''
Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode': # type: ignore
        if root == None:
            return root
        return self.dfs(root, p, q)

    def dfs(self,root: 'TreeNode', p:'TreeNode', q:'TreeNode'): # type: ignore
        if root == None:
            return root
        if root.val < p.val and root.val < q.val:
            return self.dfs(root.right, p, q)
        elif root.val > p.val and root.val > q.val:
            return self.dfs(root.left, p, q)
        else:
            return root                    