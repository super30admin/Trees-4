# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time complexity: worst case O(n)
# Space complexity: O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.counter = k
        return self.helper(root)
    def helper(self, root):
        if root == None:
            return
        left = self.helper(root.left)
        self.counter -= 1
        if self.counter == 0:
            return root.val
        right = self.helper(root.right)

        return left or right