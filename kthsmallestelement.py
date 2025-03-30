# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity  : O(n)
# Space Complexity : O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return -1
        count = k
        answer = -1
        def inorder(root):
            nonlocal answer, count
            if root == None:
                return
            inorder(root.left)
            count = count - 1
            if count == 0:
                 answer = root.val
            inorder(root.right)

        inorder(root)
        return answer