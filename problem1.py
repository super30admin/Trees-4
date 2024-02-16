# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :yes

# Definition for a binary tree node.


class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
from typing import Optional


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.result = 0
        self.count = k
        self.helper(root)
        return self.result
    
    def helper(self, root):
        if root is None:
            return
        
        self.helper(root.left)
        self.count -= 1

        if self.count == 0:
            self.result = root.val
            return
        
        if self.result == 0:
            self.helper(root.right)  

        