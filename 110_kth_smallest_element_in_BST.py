# Time complexity - O(n)
# Space complexity - O(h)

# Approach - Run inorder traversal on BST, maintain counter variable that will 
# increement and when it is equal to k, update the result.

# Definition for a binary tree node.
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return -1
        self.count = 0
        self.result = -1
        self.inorder(root, k)
        return self.result
    
    def inorder(self, root: Optional[TreeNode], k: int) -> None:
        if root == None or self.result != -1:
            return
        self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        self.inorder(root.right, k)