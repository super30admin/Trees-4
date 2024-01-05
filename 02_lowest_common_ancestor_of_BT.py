# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
we recursively check if current node == p or q if it is the check to left and right if it contain next node this determines if the node itself is an ancestor or not

if both left and right return true it means we found the ancestor and set lca to node
 and return left or right whichever (logical operation)
 
 TC: O(n), SC: O(h)
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.lca = None
        def dfsLCA(node, p, q):
            if not node:
                return False
            
            if node == p or node == q:
                if dfsLCA(node.left, p, q) or dfsLCA(node.right, p, q): #handles if p and q is ancestor
                    self.lca = node
                return True
            
            left = dfsLCA(node.left, p, q)
            right = dfsLCA(node.right, p, q)
            
            if left and right:
                self.lca = node
            return left or right
        
        dfsLCA(root, p, q)
        return self.lca
                
'''
Approach 2: without using a global variable

TC: O(n), SC: O(h)
'''

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfsLCA(node):
            if not node:
                return None
            
            if node == p or node == q:
                return node
            
            left = dfsLCA(node.left)
            right = dfsLCA(node.right)
            
            if left and right:
                return node
            if left:
                return left
            
            return right

        return dfsLCA(root)
                