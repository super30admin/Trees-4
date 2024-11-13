# 230. Kth Smallest Element in a BST
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        result = 0
        def helper(root):
            nonlocal count
            nonlocal result
            #base
            if not root: return 

            helper(root.left)
            count += 1
            if count == k:
                result = root.val
                return

            helper(root.right)

        helper(root)
        return result
       

        



        