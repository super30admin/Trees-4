# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Done on July 26, 2020
# Refer to 235 ( LCA of BST )

# Try Method 2 : Iterative method with parent pointers
# Try Method 2 : Iterative method without parent pointers

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # Method 1 : Recursion
        # Time complexity : O(n), traverse all nodes
        # Space complexity : O(n), stack space under the hood

        # base case
        if not root or p.val == root.val or q.val == root.val:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left != None and right != None:
            return root
        elif left != None:
            return left
        elif right != None:
            return right
        else:
            return None