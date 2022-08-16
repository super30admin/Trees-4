# Bottom up Approach - returning the left and right roots to its parent root
# Time Complexity = O(n)
# Space Complexity = O(h)


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root                        # If we find the root, return that to its parent root
        
        # First going all the way left, then right
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left == None and right == None:
            return None
        
        elif left != None and right == None:
            return left
        
        elif left == None and right != None:
            return right
        
        else:
            return root

        

# Brute Force with backtrack (pre order)
# Time Complexity = O(n)
# Space Complexity = O(h)

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
        
        self.pathP = []
        self.pathQ = []
        
        self.dfs(root, p, q, [])
        
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i - 1]
            
        return None
        
        
    def dfs(self, root, p, q, path):
        # Base Case
        if root == None:
            return
        
        # Logic
        # Action
        path.append(root)
        if root == p:
            self.pathP = path.copy()
            self.pathP.append(root)
                
        if root == q:
            self.pathQ = path.copy()
            self.pathQ.append(root)
            
        # Recursion
        self.dfs(root.left, p, q, path)
        self.dfs(root.right, p, q, path)
    
        # Backtrack
        path.pop(len(path) - 1)
            
        
        
