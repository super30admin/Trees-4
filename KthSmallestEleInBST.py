# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root is None:
            return 

        self.count = k
        self.result = None

        def inorder(node):
            if node is None:
                return
            if self.result == None:
                inorder(node.left)
            self.count -= 1
            if self.count == 0:
                self.result = node
            if self.result == None:
                inorder(node.right)
        
        inorder(root)
        return self.result.val

