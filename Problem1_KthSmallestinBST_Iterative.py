'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 230. Kth Smallest Element in a BST

# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while root is not None or len(stack) != 0:
            while root is not None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            
            k -= 1
            
            if k == 0:
                return root.val
            
            root = root.right
        return -1

    
