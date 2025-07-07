# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        def helper(root):
            if not root:
                return None
            l = helper(root.left)
            if self.k == 0:
                return l
            self.k -= 1
            if self.k == 0:
                return root
            r = helper(root.right)
            return l or r
        return helper(root).val