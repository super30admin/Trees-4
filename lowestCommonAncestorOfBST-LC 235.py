# Recursive Solution
# Time Complexity = O(h), moving either left or right, discarding other half
# Space Complexity = O(h), recursive stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        
        if p.val < root.val and q.val < root.val:
            # go left
            return self.lowestCommonAncestor(root.left, p, q)
        
        elif p.val > root.val and q.val > root.val:
            # go right
            return self.lowestCommonAncestor(root.right, p, q)
        
        return root
   
    
# Iterative Solution 
# Time Complexity = O(h)
# Space Complexity = O(1)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        
        while(True):
            if p.val < root.val and q.val < root.val:
                # go left
                root = root.left
        
            elif p.val > root.val and q.val > root.val:
                # go right
                root = root.right
            
            else:
                return root