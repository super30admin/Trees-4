# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def __init__(self):
        self.ppath = []
        self.qpath = []

    def lowestCommonAncestor(self, root, p, q):
        self.helper(root, [], p, q)
        for i in range(len(self.ppath)):
            if self.ppath[i] != self.qpath[i]:
                return self.ppath[i - 1]

    # def helper(self, root, path, p, q):
    #     if not root:
    #         return
    #     path.append(root)
    #     if root == p:
    #         self.ppath = path[:]
    #         self.ppath.append(root)

    #     if root == q:
    #         self.qpath = path[:]
    #         self.qpath.append(root)

    #     self.helper(root.left, path, p, q)
    #     self.helper(root.right, path, p, q)
    #     path.pop()


    def helper(self, root, path, p, q):
        if root is None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        return left or right
