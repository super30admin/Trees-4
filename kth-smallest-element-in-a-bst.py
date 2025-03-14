# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time O(n)
# Space O(n)
class Solution:
    def __init__(self):
        self.count = 0
        self.result = 0

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.inorder(root, k)
        return self.result
    
    def inorder(self, root: Optional[TreeNode], k: int) -> None:
        # base
        if root == None: return

        self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
        else:
            self.inorder(root.right, k)
