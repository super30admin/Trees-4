'''
Problem:  Lowest Common Ancestor of a Binary Search Tree
Time Complexity: O(n), where n is nodes in the tree
Space Complexity: O(n), for recursion stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        recursion applied to check for values
        if both p and q are bigger than root then recurse right
        if p and q smaller than root then recurse left
        else we found ancester
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val <p.val and root.val <q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root