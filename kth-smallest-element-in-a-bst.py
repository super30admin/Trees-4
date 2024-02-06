# Approach - inorder traversing. Increment global count with every node. When count == k, return.
# TC - O(N), SC - O(H)
# Limitation - What goes in comes out, since we pushed root at tha start inside recursive stack,
# although we have found kth smallest node, it will go to right of root.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.count = 0
        self.result = None
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.inorder(root, k)
        return self.result.val

    def inorder(self, root, k):
        # base
        if root is None: return 
        # logic
        self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root
            return
        self.inorder(root.right, k)


        