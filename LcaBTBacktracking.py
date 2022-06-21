# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# TC - O(n)
# SC - O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        path1 = []
        path2 = []

        def lca(node, path):
            nonlocal path1, path2

            if not node:
                return

            path.append(node)

            if node.val == p.val:
                path1 = path.copy()
                path1.append(node)
            if node.val == q.val:
                path2 = path.copy()
                path2.append(node)

            lca(node.left, path)
            lca(node.right, path)

            path.pop()

        lca(root, [])
        for i in range(len(path1)):
            if path1[i] != path2[i]:
                return path1[i - 1]
        return None
