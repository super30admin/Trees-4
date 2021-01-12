# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
Approach: Recursive

We are using BST property to our advantage here. We are moving either left or right.

1) If our p and q are less than root then our answer lies towards left
2) If our p and q are more than root then our answer lies towards right
3) Else our current root is the answer

TC: O(n) 
SC: O(1)

n = no of nodes in the tree

"""

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        
        return self.helper(root, p, q)
    
    
    def helper(self, root, p, q):
        if p.val < root.val and q.val < root.val:
            return self.helper(root.left, p, q)
        
        elif p.val > root.val and q.val > root.val:
            return self.helper(root.right, p, q)
        
        else:
            return root
        
"""
Apporach: Iterative apporach to previous approach

TC: O(n)
SC: O(1)

n = no of nodes in the tree

"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        while (root != None):
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
        
            else:
                return root
            
        return None
            
            
        
        