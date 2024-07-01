#Time Complexity : O(n)
#Space Complexity : O(h) - O(logn) or O(n)
#Any problem you faced while coding this : -

#The approach is conditionally check left and right subtrees root values with p and q. Even if we find one child's parent, we bubble up the node through the call and ultimately we can apply conditions to fetch the common ancestor.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None:
            return None
        elif left is not None and right is None:
            return left
        elif left is None and right is not None:
            return right
        else:
            return root
