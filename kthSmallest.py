#Time: O(h)
#Space: O(h)
#Program ran on leetcode successfully

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    
    def __init__(self):
        self.count = -1
        self.result = -1
        self.flag = False
        
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.count = k
        self.inorder(root)
        return self.result
    
    def inorder(self, root):
        if root is None:
            return
        if not self.flag:
            self.inorder(root.left)
        self.count += -1
        if self.count == 0:
            self.flag = True
            self.result = root.val
        if not self.flag:
            self.inorder(root.right)
        