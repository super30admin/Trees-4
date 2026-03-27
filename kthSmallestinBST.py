# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We’re doing an in-order traversal, but we stop early once we find the kth smallest element.
# We use count to track how many nodes we’ve visited so far.
# By checking if result is still null, we avoid unnecessary recursion after finding the result.

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
        self.helper(root, k)
        return self.result.val

    def helper(self, root, k):
        if not root:
            return
        if self.result is None:
            self.helper(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root
        if self.result is None:
            self.helper(root.right, k)

        