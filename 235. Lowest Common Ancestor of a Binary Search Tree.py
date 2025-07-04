# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Time complexity: O(h)
# Space complexity: O(h)

# EXPLANATION
    # Use the property of BST check if left and right are what comparing to the node

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if root == None:
#             return None
#         if p.val < root.val and q.val < root.val:
#             return self.lowestCommonAncestor(root.left, p, q)
#         elif p.val > root.val and q.val > root.val:
#             return self.lowestCommonAncestor(root.right, p, q)
#         else:
#             return root
        

# Iterative solution with no extra space i.e. O(1) space complexity

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        while root != None:
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root