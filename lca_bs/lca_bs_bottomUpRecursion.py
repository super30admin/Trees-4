'''
Time Complexity: 0(n) -- all the nodes
Space Complexity: 0(h) --- recursion stack
Run On LeetCode: Yes
Bottom Up Recursion
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''bottom up recursion'''
class Solution:
    
    def dfsTraversal(self,node,p,q):
        # base-case
        if node == None:
            return None
        elif node == p or node == q:
            return node
        
        # logic-case
        # 1. traverse on the lhs and rhs 
        lhs = self.dfsTraversal(node.left,p,q)
        rhs = self.dfsTraversal(node.right,p,q)
        
        # 2. chk for cases
        if lhs != None and rhs != None:
            # I am standing on the ancestor
            return node
        elif lhs != None and rhs == None:
            return lhs
        elif lhs == None and rhs != None:
            return rhs
        elif lhs == None and rhs == None:
            return None
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfsTraversal(root,p,q)