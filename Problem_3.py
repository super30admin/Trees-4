# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.path1, self.path2 = [], []
        self.findPath(root, p, q, [])
        for i in range(len(self.path1)):
            if self.path1[i] != self.path2[i]:
                return self.path1[i-1]
        return None
    
    def findPath(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', path: 'list'):
        if root == None:
            return
        if root == p:
            self.path1 = path.copy()
            self.path1.append(p)
            self.path1.append(p)
        if root == q:
            self.path2 = path.copy()
            self.path2.append(q)
            self.path2.append(q)
        path.append(root)
        if len(self.path1) == 0 or len(self.path2) == 0:
            self.findPath(root.left, p, q, path)
        if len(self.path1) == 0 or len(self.path2) == 0:
            self.findPath(root.right, p, q, path) 
        path.pop()

# Time Complexity: O(n)
# Space Complexity: O(n)


# Using no extra space 
# Bottom -up recursion
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left != None and right != None:
            return root
        if left != None:
            return left
        if right != None:
            return right
        else:
            return None


# Time Complexity: O(n)
# Space Complexity: O(n) - Only recursive stack space


