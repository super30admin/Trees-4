# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time Complexity: O(n) n is the total number of elements
    # Space Complexity: O(h) h being the height of the tree
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > p.val and root.val > q.val: return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < p.val and root.val < q.val: return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root



