'''
Time Complexity - O(n)
Space Complexity - O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.result = None
        self.flag = False

        def inorder(root):
            if root == None:
                return
            if not self.flag:
                inorder(root.left)
            self.count -= 1
            if self.count == 0:
                self.flag = True
                self.result = root.val
                return self.result
            if not self.flag:
                inorder(root.right)
        inorder(root)
        return self.result
