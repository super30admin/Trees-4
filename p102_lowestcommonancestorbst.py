"""
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as
descendants (where we allow a node to be a descendant of itself).”


TC: O(n)
sc: O(n)
Appoach: We approach the right side of the tree recursively if both pq are greater than root else if we approach the left
side of the tree recursively if both pq are smaller than root else if they are on either sides we just return the root
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        ##tree left right
        # if root==None:
        #     return
        # if p.val<root.val and q.val>root.val:
        #     return root
        # ##tree left
        # elif p.val > root.val and q.val>root.val:
        #     return self.lowestCommonAncestor(root.left, p, q)
        # elif p.val < root.val and q.val<root.val:
        #     return self.lowestCommonAncestor(root.right, p, q)
        # ###tree right
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root





