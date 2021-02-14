# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    """
    Description: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST
    
    Time Complexity: O(n)
    Space Complexity: O(h), where h is height of the tree
    
    Approach:
    - DFS with backtracking to keep a list of nodes in a given path
    - return path twice when the given node p or q matches with path
    - use both paths and check if the root matches, if not return None
    """
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None: return
        
        self.path1 = []
        self.path2 = []
            
        self.helper(root, p, self.path1)
        self.helper(root, q, self.path2)

        for i, value in enumerate(self.path1):
            if self.path1[i] != self.path2[i]:
                return self.path1[i - 1]
            
    def helper(self, root, p, path):
        
        # base
        if root == None: return
        
        # logic
        if root == p: path.append(p)
        
        # action
        path.append(root)
        
        # recurse
        self.helper(root.left, p, path)
        if path[len(path) - 1] == p: return path
        self.helper(root.right, p, path)
        if path[len(path) - 1] == p: return path
        
        # backtrack
        path.pop()
        
        return path
