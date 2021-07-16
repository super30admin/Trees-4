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
        self.result = -1
        self.count = 0
        self.inorder(root, k)
    
        return self.result

    def inorder(self, root:TreeNode, k:int) -> int:
        #Base
        if root is None:
            return None
        #Logic
        if self.result == -1:
            self.inorder(root.left, k)
        
        self.count += 1
        
        if self.count == k:
            self.result = root.val
        
        if self.result == -1:        
            self.inorder(root.right, k)
    
