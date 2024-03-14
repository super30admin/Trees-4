'''
TC: O(n) - n is the number of nodes
SC: O(h) - h is the height of the binary search tree
'''
# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.res = None

        def dfs(root):
            if not root:
                return
            left = dfs(root.left)
            self.k = self.k-1
            if self.k == 0:
                self.res = root.val
            if self.k > 0:
                right =  dfs(root.right)
        
        dfs(root)
        return self.res