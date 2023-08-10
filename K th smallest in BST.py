# Time Complexity : O(N), number of nodes in the tree
# Space Complexity : O(H), height of the tree for the recursive stack
# The code ran on LeetCode

# Inorder Traversal to get the elemnet at k th index in sorted array

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        result = None
        count = k
        def inorder(root):
            nonlocal result
            nonlocal count
            # Base
            if root == None:
                return

            inorder(root.left)
            count-=1
            if count == 0:
                result = root

            inorder(root.right)

        inorder(root)
        return result.val