# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
always setting q to be the larger number between p and q

p.val <= root.val <= q.val  this checks if current node is the root element and the equality checks for common root
if root is lesser the minimum value the move to right
if root is greater than max then move left

TC: O(n), SC: O(1)// since recursive solution
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > q.val: #always setting q to be the larger number between p and q
            p, q = q, p
        while(root):
            
            if p.val <= root.val <= q.val:
                return root
            elif root.val < p.val: # if root is lesser the minimum value the move to right
                root = root.right
            else: #if root is greater than max then move left
                root = root.left
        return None
            
        