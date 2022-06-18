'''
Time Complexity: 0(h)
Space Complexity: 0(h) -- recursive stack 

h is the height of the tree

Run On LeetCode: Yes
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def bfsTraversal(self,node,p,q):
        
        # Case 1: go lhs
        if p.val < node.val and q.val < node.val:
            return self.bfsTraversal(node.left,p,q)
        
        # Case 2: go rhs
        elif p.val > node.val and q.val > node.val:
            return self.bfsTraversal(node.right,p,q)
        
        # Case 3: p == node or q == node
        elif p == node or q == node:
            return node
        
        # Case 4: disjoint
        elif (p.val < node.val and q.val > node.val) or (q.val < node.val and p.val > node.val):
            return node
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.bfsTraversal(root,p,q)