# time complexity is o(n), where n is the size of the input Tree
# space complexity is o(1).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root, p ,q)
    
    def helper(self, root, p, q):
        if(root == None):
            return None
        if(root == p):
            return root
        if(root == q):
            return root
        
        left = self.helper(root.left, p, q)
        right = self.helper(root.right, p, q)
        if(not left and not right):
            return None
        if(left and not right):
            return left
        if(right and not left):
            return right
        else:
            return root
        
        
# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
# Recursive stack space is o(h), where h = log(n), where n is the size of the input
#         pathp = []
#         pathq = []
        
#         self.helper(root, [], p, q, pathp, pathq)
#         for i in range(len(pathp)):
#             if(i > 0 and pathp[i] != pathq[i]):
#                 return pathp[i-1]
        
                
#     def helper(self, root, path, p, q,  pathp, pathq):
#         if(root == None):
#             return 
        
#         path.append(root)
#         if(p == root):
#             pathp.extend(path.copy())
#             pathp.append(root)
        
#         if(q == root):
#             pathq.extend(path.copy())
#             pathq.append(root)
        
#         self.helper(root.left,  path, p, q,  pathp, pathq)
#         self.helper(root.right, path, p, q,  pathp, pathq)
#         path.pop()
        
        