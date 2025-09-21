#  Time Complexity :  O(h) -> for balanced Tree O(n) -> for skewed tree
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds the Lowest Common Ancestor (LCA) of two nodes p and q in a Binary Search Tree (BST). It keeps traversing down from the root: if both p and q are smaller than root, it moves left; if both are greater, it moves right. The moment p and q split into different sides (or one equals root), it returns the current root as their LCA.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True:
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root 
