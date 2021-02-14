# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Approach: Recursion
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, n and h are the size and height of the tree, respectively
        
        #base
        if not root or root == p or root == q:
            return root
        
        #logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left and right:
            return root
        elif left:
            return left
        elif right:
            return right
        else:
            return None
    
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Approach: Finding path using dfs/inorder traversal
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, n and h are the size and height of the tree, respectively
        
        self.pPath = self.qPath = None
        
        self.backtrack(root, path, p, q)
        
        i = 0
        while i < len(self.pPath) and i < len(self.qPath) and self.pPath[i] == self.qPath[i]:
            i += 1
        return self.pPath[i - 1]
    
    def backtrack(self, root, path, p, q):
        #base
        if path[-1] == p:
            self.pPath = path.copy()
        elif path[-1] == q:
            self.qPath = path.copy()
        
        if not root or (self.pPath and self.qPath):
            return
        
        
        #logic
        path.append(root)       #action
        
        #recursion
        self.backtrack(root.left, path, p, q)
        self.backtrack(root.right, path, p, q)
        
        path.pop()              #backtrack
    """