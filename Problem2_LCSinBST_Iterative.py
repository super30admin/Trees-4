'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 235. Lowest Common Ancestor of a Binary Search Tree

# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

#-----------------
# Time Complexity: 
#-----------------
# O(logN) - Where N is the number of nodes

#------------------
# Space Complexity: 
#------------------
# O(1): No extra space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Iterative: time: O(logN) space: O(1)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        while root is not None:
            if root.val < p.val and root.val < q.val:
                root = root.right

            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root
        
        return root
