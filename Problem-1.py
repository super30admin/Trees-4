# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = None
        self.count = 0

    def kthSmallest(self, root, k) :

        self.result = -1

        self.inorder(root, k)
        return self.result

    def inorder(self, root, k):
        # base
        if root == None:
            return

        # logic
        self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return

        self.inorder(root.right, k)
