# Approach: To deal with cases where one path might be shorter than the other we add the target node twice
# Maintain paths and iterate over to see where the values differ and return the node before it which will be the ancestor
# Time - O(N)
# Space - O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None:
            return None
        
        paths1 = []
        paths2 = []
        
        self.backtrack(root, p, paths1)
        self.backtrack(root, q, paths2)
        
        # iterate over any one path as we made their lengths equal
        for i in range(len(paths1)):
            if paths1[i] != paths2[i]:
                return paths1[i-1]
            
            
    def backtrack(self, root, p, path):
        
        # base case
        if root == None:
            return 
        
        if root == p:
            path.append(root)
        
        #logic
        
        path.append(root)
        
        self.backtrack(root.left, p, path)
        if path[-1] == p:
            return 
        
        self.backtrack(root.right, p, path)
        if path[-1] == p:
            return 
        
        path.pop()



# another way of approach 1

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None:
            return None
        
        paths1 = []
        paths2 = []
        
        self.backtrack(root, p, paths1)
        self.backtrack(root, q, paths2)
        
        # iterate over any one path as we made their lengths equal
        for i in range(len(paths1)):
            if paths1[i] != paths2[i]:
                return paths1[i-1]
            
            
    def backtrack(self, root, p, path):
        
        # base case
        if root == None:
            return 
        
        if root == p:
            # adding target twice
            path.append(root)
            path.append(root)
            return 
        
        #logic
        
        path.append(root)
        
        self.backtrack(root.left, p, path)
        
        self.backtrack(root.right, p, path)
        if path[-1] == p:
            return 
        
        path.pop()