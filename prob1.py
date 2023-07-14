# Time Complexity :O(n)
# Space Complexity :O(h)
# Leet Code: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.result = TreeNode()
        self.helper(root)
        return self.result.val
        

    def helper(self, root):
            # base
            if root is None:
                return None

            # logic
            self.helper(root.left)
            self.count -= 1
            if self.count == 0:
                self.result = root
            self.helper(root.right)
