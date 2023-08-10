# Time Complexity : O(H), height of the tree
# Space Complexity : O(1)
# The code ran on LeetCode

# Move to the left portion of BST if root.val > p.val and root.val > q.val. Move right if root.val < p.val and root.val < q.val. Return root if none of the previous cases are correct.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        while True:
            if root.val > p.val and root.val > q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root