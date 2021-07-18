# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(k + h) h - height of tree
# Space Complexity: O(h)
class Solution:
    def kthSmallest(self, root, k):
        # Initialize the stack and until true we will iterate and check if root not null
        # then we will append it to the stack and assign root to root.left and
        # until we reach leftmost end. after that we will pop from the stack decremnt k by 1
        # and if k == 0 we will return root value else will assign root to root.right
        stack = []
        while True:

            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right

