# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is not None and right is not None:
            return root
        elif left is not None:
            return left
        elif right is not None:
            return right
        else:
            return None


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        path1 = []
        path2 = []
        self.helper(root, p, path1)
        self.helper(root, q, path2)
        for i in range(len(path1)):
            if path1[i] != path2[i]:
                return path1[i - 1]
        return None

    def helper(self, root, p, path):
        # Base
        if root == None:
            return
        if root == p:
            path.append(root)
            path.append(root)
            return
        # logic

        path.append(root)

        # recurse
        self.helper(root.left, p, path)
        self.helper(root.right, p, path)

        if path[len(path) - 1] == p:
            return
        # backtrack
        path.pop()


