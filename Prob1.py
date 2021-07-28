# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.res = -1
        self.k = k
        def inorder(root):
            #base
            if root is None:
                return
            #logic
            if self.res is -1:
                inorder(root.left)
            self.k -= 1
            if self.k is 0:
                self.res = root.val
            if self.res is -1:
                inorder(root.right)
        inorder(root)
        return self.res
