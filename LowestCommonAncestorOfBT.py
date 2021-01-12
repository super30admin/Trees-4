# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


"""
Approach: DFS

TC: O(n). We may traverse all the nodes
SC: O(n). We are storing in list

n = no of nodes
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        
        path1 = [] # path for p
        path2 = [] # path for q
        
        self.backtrack(root, p, path1)
        self.backtrack(root, q, path2)
        n1 = len(path1)
        n2 = len(path2)
        
        i = 0
        while i < min(n1,n2):
            if path1[i] != path2[i]:
                break
            i += 1
        
        return path1[i - 1]
        
    def backtrack(self, root, node, path):
        if root == None:
            return
        
        path.append(root)
        
        # Instead of comparing values its better to compare references, because even we get duplicated values the code should work
        if root == node:
            return
        
        self.backtrack(root.left, node, path)
        
        """
        We are adding this because without it the recursion will keep going even after we got the path.
        It is performing correctly before the value being found but after the path is found we need stop           it there. So after the path is found, keep returning until recurssion stack is empty.  
        
        Basically this condition makes the removing stop once path is found.    
        """
        if path[-1] == node:
            return
        
        self.backtrack(root.right, node, path)
        if path[-1] == node:
            return
        
        path.pop()
        
        
