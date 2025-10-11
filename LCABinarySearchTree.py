# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Time Complexity: O(h) where h is the height of the tree. and space is O(h) as well for recursion depth
class Solution:
    def lowestCommonAncestorRecursion(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestorRecursion(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestorRecursion(root.right, p, q)
        else:
            return root


    # Time complexity is same O(h), however using a while loop gives a space of O(1).
    # The intuition is simple, if both p and q are on left then go left, if they are on right then go right otherwise the LCA is the root.
    class Solution:
        def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
            while True:
                if p.val < root.val and q.val < root.val:
                    root = root.left
                elif p.val > root.val and q.val > root.val:
                    root = root.right
                else:
                    return root