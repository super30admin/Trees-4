# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.result = None
        self.count = 0

        def inorder(node):
            if node is None:
                return
            inorder(node.left)  # Traverse left subtree
            self.count += 1
            if self.count == k:
                self.result = node.val  # Found the kth smallest element
                return
            inorder(node.right)  # Traverse right subtree

        inorder(root)
        return self.result

        