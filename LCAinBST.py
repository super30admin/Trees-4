# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        qu = [root]

        while qu:
            curr = qu.pop()

            if curr == p or curr == q:
                return curr
            
            if p.val < curr.val < q.val or p.val > curr.val > q.val:
                return curr
            
            if curr.left:
                qu.append(curr.left)
            
            if curr.right:
                qu.append(curr.right)
        


            
