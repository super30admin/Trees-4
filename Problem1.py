'''
Time Complexity: O(k)
Space Complexity: O(h) where h is the height of the tree
Run on Leetcode: YES
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.result = 0
        def inorder(root: Optional[TreeNode]):
            if not root:
                return
            inorder(root.left)
            self.count -= 1
            if self.count == 0:
                self.result = root.val
                return
            inorder(root.right)
        inorder(root)
        return self.result