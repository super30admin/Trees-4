# Definition for a binary tree node.
#Time complexity: O(n)
#Space complexity: O(h)
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root,p,q)
        
    def helper(self,curr,p,q):
        if (not curr) or curr == p or curr==q:
            return curr
        left= self.helper(curr.left,p,q)
        right= self.helper(curr.right,p,q)
        if not left:
            return right
        elif left and not right:
            return left
        else:
            return curr
        
            
        