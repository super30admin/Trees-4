# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        kth = 0

        def helper(root):
            nonlocal count
            nonlocal kth
            if root == None:
                return
            if count < k:
                helper(root.left)
            if count < k:
                count += 1
                kth = root.val
            if count < k:
                helper(root.right)

        helper(root)
        return kth
