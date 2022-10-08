'''
Time Complexity - O(n)
Space Complexity - O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathp = []
        self.pathq = []

        def helper(root, path):
            if root == None:
                return
            path.append(root)
            if root == p:
                self.pathp = list(path)
            if root == q:
                self.pathq = list(path)
            helper(root.left, path)
            helper(root.right, path)
            path.pop()
        helper(root, [])
        res = None
        for i, j in zip(self.pathp, self.pathq):
            if i.val == j.val:
                res = i
            else:
                break
        return res
