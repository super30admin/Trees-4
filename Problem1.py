# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inorder(node):
            return inorder(node.left) + [node.val] + inorder(node.right) if node else []

        elements = inorder(root)
        return elements[k - 1]
