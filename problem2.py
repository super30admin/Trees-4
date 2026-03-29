# problem 2 

# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def helper(self,root,p,q):
        if not root or root == p or root == q:
            return root
        nodeleft = self.helper(root.left,p,q)
        noderight = self.helper(root.right,p,q)
        if nodeleft is None and noderight is None:
            return None 
        elif nodeleft is not None and noderight is None:
            return nodeleft
        elif nodeleft is None and noderight is not None:
            return noderight
        return root
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root,p,q)