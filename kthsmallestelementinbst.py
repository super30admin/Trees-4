# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return None

        self.count = k
        self.result = None
        self.inorder(root)
        return self.result.val

    def inorder(self, root):
        if not root or self.count == 0:
            return

        self.inorder(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root
        self.inorder(root.right)


