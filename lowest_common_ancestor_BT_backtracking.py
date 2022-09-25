# Time Complexity : O(H) or O(log N) whenre H is height of the BST and N is number of Nodes in the tree
# Space Complexity : O(H) whenre H is height of the BST
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.pPath = []
        self.qPath = []
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        self.findPaths(root, p, q, [])
        i = 0
        while i < len(self.pPath) and i < len(self.qPath) and self.pPath[i] == self.qPath[i]:
            i += 1
        
        return self.pPath[i-1] 
        
        
    def findPaths(self, root, p, q, path):
        #base
        if root == p:
            self.pPath = path[:]
            self.pPath.append(p)
        if root == q:
            self.qPath = path[:]
            self.qPath.append(q)
        if root == None:
            return
        
        #logic
        path.append(root)
        
        self.findPaths(root.left, p, q, path)
        
        self.findPaths(root.right, p, q, path)
        
        path.pop()