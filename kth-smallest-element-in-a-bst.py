# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Brute Force Recursion with list
#TC : O(n)
#SC : O(n)
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """

        self.result = []
        self.inorder(root)
        return self.result[k-1]

    def inorder(self, root):

        if root is None:
            return
        self.inorder(root.left)
        self.result.append(root.val)
        self.inorder(root.right)

#Conditional Recursion
#TC : O(n)
#SC : O(h )
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """

        self.result = None
        self.count = 0
        self.inorder(root,k)
        return self.result

    def inorder(self, root, k):

        if root is None:
            return
        self.inorder(root.left,k)
        self.count += 1
        if self.count == k:
            self.result = root.val
        if self.result is None:
            self.inorder(root.right,k)

#Iterative
#TC : O(n)
#SC : O(h )
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """

        self.result = None
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right