# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    
"""

        Name : Shahreen Shahjahan Psyche
        Time : O(log N) [Where N repreesents the number of Nodes]
        Space: Recursive Solution : O(H) [Recursive Stack Space]
               Iterative Solution : O(H) [Auxiliary External Stack]
        
        Passed Test Cases in LC : Yes


"""
    
    # Recursive Solution
    def recursive(self, root, p, q):
        
        if p.val > root.val and q.val > root.val:
            return self.recursive(root.right, p, q)
        elif p.val < root.val and q.val < root.val:
            return self.recursive(root.left, p, q)
        else:
            return root
    
    # Iterative Solution
    def iterative(self, root, p, q):
        
        track = []
        track.append(root)
        
        # Using the BST property to find the LCA
        while root:
            # if my both values are less than current node's value that means both of them are in left side of the tree
            if root.val > p.val and root.val > q.val:
                root = root.left 
             # if my both values are greater than current node's value that means both of them are in right side of the tree
            elif root.val < p.val and root.val < q.val:
                root = root.right
            # if one is greater and anotheer one is smaller that means thee current node is the LCA
            else:
                return root
        
        return
                
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if not root:
            return
        
        return self.iterative(root, p, q)
        
