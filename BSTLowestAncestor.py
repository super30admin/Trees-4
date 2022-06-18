# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        curr=root
        while curr:
            if p.val<curr.val and q.val<curr.val:
                curr=curr.left
            elif p.val>curr.val and q.val>curr.val:
                curr=curr.right
            else:
                return curr