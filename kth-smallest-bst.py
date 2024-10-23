#Time complexity: O(n)
#Space complexity: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = k
        res = 0
        flag = False
        def inorder(root):
            nonlocal count
            nonlocal res
            nonlocal flag
            if root == None: return
            inorder(root.left)
            count-=1
            if count == 0:
                res = root.val
                flag = True
            if not flag:
                inorder(root.right)
        inorder(root)
        return res