# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Method 1 - Build path till you find p,q. Then iterate the path and the first uncommon node, the previous common is the LCA.
        if root is None:
            return
        def backtrack(node, path):
            nonlocal pathP, pathQ
            #base
            if node is None:
                return

            #logic
            #ACTION
            path.append(node)
            if node == p:
                pathP = path.copy()
                pathP.append(p) #add p to it again for the edge case where p itself is the LCA, then it'll go out of bounds while iterating, so just repeat p in your path

            if node == q:
                pathQ = path.copy()
                pathQ.append(q) #add q to it again for the edge case where q itself is the LCA, then it'll go out of bounds while iterating, so just repeat q in your path

            #RECURSION
            backtrack(node.left, path)
            backtrack(node.right, path)
            #BACKTRACK
            path.pop()

        pathP = []
        pathQ = []
        backtrack(root, [])
        for i in range(len(pathP)):
              if pathP[i] != pathQ[i]: #the moment it's not equal, it's the previous element.
                  return pathP[i-1]
        return None


