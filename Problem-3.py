'''
    Time Complexity: O(n)
    Space Complexity: O(2logn)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import copy

class Solution:
    def __init__(self):
        self.pathP = []
        self.pathQ = []

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.helper(root, p, q, [root])

        i = 0
        while i < len(self.pathP) and i < len(self.pathQ):
            if self.pathP[i].val != self.pathQ[i].val:
                return self.pathP[i-1]
            
            i += 1
        

    def helper(self, root, p, q, curPath):
        # base case
        if not root:
            return

        # logic
        if root == p:
            self.pathP = copy.deepcopy(curPath)
            self.pathP.append(root)

        if root == q:
            self.pathQ = copy.deepcopy(curPath)
            self.pathQ.append(root)

        if not len(self.pathP) or not len(self.pathQ):
            curPath.append(root.left)
            self.helper(root.left, p, q, curPath)
            curPath.pop()

            curPath.append(root.right)
            self.helper(root.right, p, q, curPath)
            curPath.pop() 
