# problem 3 
# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
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
        leftnode = self.helper(root.left,p,q)
        rightnode = self.helper(root.right,p,q)
        if leftnode is None and rightnode is None:
            return None 
        elif leftnode is not None and rightnode is None:
            return leftnode
        elif leftnode is None and rightnode is not None:
            return rightnode
        return root

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root,p,q)