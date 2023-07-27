# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if root is None:
            return

        pathP = []
        pathQ = []

        def backtrack(node, path):
            nonlocal pathP, pathQ
            if node is None:
                return
            path.append(node)
            if node == p:
                pathP = path.copy()
                pathP.append(p)

            if node == q:
                pathQ = path.copy()
                pathQ.append(q)

            
            backtrack(node.left, path)
            backtrack(node.right, path)
            path.pop()


        backtrack(root, [])
        for i in range(len(pathP)):
              if pathP[i] != pathQ[i]:
                  return pathP[i-1]
        return None



