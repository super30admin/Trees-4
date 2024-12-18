# The kthSmallest method finds the kth smallest element in a binary search tree.

# Use in-order traversal (DFS) to traverse nodes in sorted order.
# Decrement a counter during traversal:
# - When the counter reaches 0, store the current node's value as the result and stop further traversal.

# Return the stored result after traversal.

# TC: O(h + k) - Traverse k nodes, where h is the tree height for recursion.
# SC: O(h) - Space for the recursion stack.


# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        cnt = k
        res = root.val

        def dfs(node):
            nonlocal cnt, res
            if not node:
                return
            
            dfs(node.left)
            cnt -= 1
            if cnt == 0:
                res = node.val
                return
            dfs(node.right)
        
        dfs(root)
        return res