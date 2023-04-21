# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    global pathP, pathQ
    pathP = []
    pathQ = []

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        global pathP, pathQ

        # Approach 1: Maintain paths

        def backtrack(root, p, q, path):
            global pathP, pathQ
            # Base case
            if root == None: return

            # action
            path.append(root)

            # logic
            if root == p:
                pathP = copy.copy(path)
                pathP.append(p)
                # print(pathP)
            if root == q:
                pathQ = copy.copy(path)
                pathQ.append(q)
                # print(pathQ)

            # Recurse
            backtrack(root.left, p, q, path)
            backtrack(root.right, p, q, path)

            # Backtrack
            path.pop()

        backtrack(root, p, q, [])
        # print(pathP)
        # print(pathQ)
        for i in range(len(pathP)):
            if pathP[i] != pathQ[i]:
                # print(pathP[i])
                # print(pathQ[i])
                return pathP[i - 1]
        return None
