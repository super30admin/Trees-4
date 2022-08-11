# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Time Complexity : o(N)
    # space Complexity : o(N)
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = 0
        self.helper(root, k)
        return self.result

    def helper(self, root, k):
        if not root:
            return
        self.helper(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return;
        self.helper(root.right, k)
        return