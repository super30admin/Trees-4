# 236. Lowest Common Ancestor of a Binary Tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        pPath = []
        qPath = []
        def helper(root,p,q,path):
            nonlocal pPath
            nonlocal qPath
            #base
            if not root: return 

            #logic
            path.append(root)
            if root.val == p.val:
                pPath = list(path)
                pPath.append(root)
            elif root.val == q.val:
                qPath = list(path)
                qPath.append(root)
            helper(root.left,p,q,path)
            helper(root.right,p,q,path)

            #backtrack
            path.pop()

        helper(root,p,q,[])
        for i in range(len(pPath)):
            if pPath[i] != qPath[i]:
                return pPath[i-1]

        