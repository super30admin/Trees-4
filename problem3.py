# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :yes


# Definition for a binary tree node.
class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathP = []
        self.pathQ = []
        self.helper(root, p, q, [])
        self.pathP.append(p)
        self.pathQ.append(q)
        for i in range(min(len(self.pathP), len(self.pathQ))):
            currP = self.pathP[i]
            currQ = self.pathQ[i]
            if currP != currQ:
                return self.pathP[i - 1]
        return None
    
    def helper(self, root, p, q, path):
        if not root:
            return None
        path.append(root)
        if root == p:
            self.pathP = path[:]
        if root == q:
            self.pathQ = path[:]
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        path.pop()

        
