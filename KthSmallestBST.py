"""
Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

"""

# Time Complexity : O(n)
# Space Complexity : O(h) h = height of tree
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        self.count = k
        self.result = None
        self.helper(root)

        return self.result

    def helper(self, root):
        
        # base 
        if root is None:
            return root

        # logic
        self.helper(root.left)

        self.count -= 1

        if self.count == 0:
            self.result = root.val
            return

        if self.count < 0:
            return

        self.helper(root.right)
        