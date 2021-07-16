'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 236. Lowest Common Ancestor of a Binary Tree

# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

#-----------------
# Time Complexity: 
#-----------------
# O(N) - Where N is the number of nodes. 

#------------------
# Space Complexity: 
#------------------
# O(N): Stack space

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
        # Base
        if root is None or root == p or root == q:
            return root
        # Logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left is not None and right is not None:
            return root
        
        elif left is not None:
            return left
        
        elif right is not None:
            return right
        
        else:
            return None    
