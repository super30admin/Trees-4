# Time complexity - O(n)
# Space complexity - O(h) (O(3h) - O(h) for path p, O(h) for path q, O(h) for 
# recursive stack)

# Approach - Maintain paths for both nodes p and q, run dfs and keep appending root
# to the path. If root equals p or q, update path for them, run dfs on root.left
# and root.right and backtrack to get accurate path.

# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', \
        q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return root
        self.pathP = []
        self.pathQ = []
        self.dfs(root, p, q, [])
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                break
        return self.pathP[i-1]
    
    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', \
        path: List['TreeNode']) -> None:
        if root is None:
            return root
        path.append(root)
        if root == p:
            self.pathP = [i for i in path]
            self.pathP.append(root)
        if root == q:
            self.pathQ = [i for i in path]
            self.pathQ.append(root)
        
        self.dfs(root.left, p, q, path)
        self.dfs(root.right, p, q, path)
        path.pop()