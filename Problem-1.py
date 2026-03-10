# Time Complexity : O(h + k), h = height of tree, k = kth element
# Space Complexity : O(h), recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Perform an in-order traversal (left, root, right) which yields elements in sorted order for BST.
# 2. Keep a counter and return the value when the counter reaches k.
# 3. Recursion stack space is O(h), where h is the height of the tree.

from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = None
        
        def inorder(node):
            if not node:
                return
            inorder(node.left)
            self.count += 1
            if self.count == k:
                self.result = node.val
                return
            inorder(node.right)
        
        inorder(root)
        return self.result