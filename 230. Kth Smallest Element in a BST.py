# Time and Space Complexity : O(N) & O(N)
# The idea is if we do inorder traversal on a BST, it will return non decreasing order of the elements
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    count = 0
    result = None

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.inorder(root)
        return self.result.val 

    def inorder(self, root):
        # Base case
        if root is None:
            return

        # In-order traversal
        self.inorder(root.left)

        # Check if the current node is the kth smallest element
        self.count -= 1
        if self.count == 0:
            self.result = root  # Update the class attribute
        self.inorder(root.right)
