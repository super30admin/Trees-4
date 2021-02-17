# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path1 = []
        path2 = []
        self.backtrack(root, p, path1)  
        self.backtrack(root, q, path2)
        
        for i in range(len(path1)):
            if(path1[i] != path2[i]):
                return path1[i-1]
        
        return None
    
    def backtrack(self, root, p, path):
        # base
        if(root == None):
            return
        if(root == p):
            path.append(root)
            path.append(root)
            return
        
        # logic
        path.append(root)
        
        # recurse
        # After check on a side is complete, if the last stored node is p then stop the recursion and return
        self.backtrack(root.left, p, path)
        if(path[-1] == p):
            return
        self.backtrack(root.right, p, path)
        if(path[-1] == p):
            return
        
        # backtrack
        # if both left and right paths did not work out, then remove curr root from path
        path.pop()
        