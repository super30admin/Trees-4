"""
do inorder traversal until k elements are retrieved
TC: O(H)
SP: O(k)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def helper(root, res):
            if not root or len(res)==k:
                return
            helper(root.left, res)
            if len(res)<k:
                res.append(root.val)
            helper(root.right, res)
        res = []
        
        helper(root, res)
        return res[-1]