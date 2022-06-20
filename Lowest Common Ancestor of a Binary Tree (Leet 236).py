'''
Top Down Recursion
Time: O(n)
Space: O(n) - path list
       O(h) - recursive stack
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.path1 = list()
        self.path2 = list()

        if root is None or root.val == p.val or root.val == q.val:
            return root

        self.backtrack(root, p, q, [])

        for i in range(len(self.path1)):
            if self.path1[i] != self.path2[i]:
                return self.path1[i-1]

        return None
    
    def backtrack(self, root, p, q, path):
        if root is None:
            return
        
        path.append(root)
        
        if root == p:
            self.path1 = path.copy()
            self.path1.append(root)
        elif root == q:
            self.path2 = path.copy()
            self.path2.append(root)
        

        self.backtrack(root.left, p, q, path)

        self.backtrack(root.right, p, q, path)
        path.pop()
            
        
'''
Bottom up Recursion
Time: O(n)
Space: O(h) - recursive stack
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left != None and right != None:
            return root
        
        elif left != None and right == None:
            return left
        
        elif right != None and left == None:
            return right
        
        else:
            return None
        