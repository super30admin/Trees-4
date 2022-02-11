# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity : O(n)
# Space Complexity: o(h)
class Solution:

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.result = None

        self.helper(root)

        return self.result

    def helper(self, root):
        # base case
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
