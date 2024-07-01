#Time Complexity : O(logn)
#Space Complexity : O(h) - O(n) for skewed and O(logn) for the best case scenario
#Any problem you faced while coding this : -

#The approach is to compare the p and q nodes with the root node's value and then decide which subtree to traverse. When we find the root node which lies between the range and p and q, we return that root node through the recursive call.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)

        return root