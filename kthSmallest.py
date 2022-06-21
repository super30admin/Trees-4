# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# TC - O(n)
# SC - O(n)
class Solution:

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        result = -1
        count = k

        def findKthSmallest(node):
            nonlocal result, count
            if not node:
                return
            findKthSmallest(node.left)
            count -= 1
            if count == 0:
                result = node.val
                return
            if count > 0:
                findKthSmallest(node.right)

        findKthSmallest(root)
        return result
