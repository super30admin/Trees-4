#Time Complexity - O(n)
#Space Complexity - O(n)
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
        if not root:
            return 0
        self.ans = []
        def ino(root):
            if root:
                ino(root.left)
                self.ans.append(root.val)
                ino(root.right)
        ino(root)
        return self.ans[k-1]
            