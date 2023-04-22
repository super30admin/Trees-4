# Time Complexity - O(n)
# Space Complexity - O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return -1
        self.count = k
        self.result = -1
        self.inorder(root)
        return self.result

    def inorder(self, root):
        if not root:
            return -1
        self.inorder(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root.val
            return
        self.inorder(root.right)
