# Time Complexity : O(n)
# Space Complexity : O(h)
from typing import TreeNode
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root, path):
            nonlocal pathp, pathq
            if root == None:
                return

            path.append(root)
            if root == p:
                pathp = path.copy()
                pathp.append(p)
            if root == q:
                pathq = path.copy()
                pathq.append(q)
            
            helper(root.left, path)
            helper(root.right, path)

            path.pop()

        pathp = []
        pathq = []
        helper(root, [])

        for i in range(len(pathp)):
            if pathp[i] != pathq[i]:
                return pathp[i-1]
        
        return None