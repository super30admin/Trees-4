# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# POSTORDER Traversal (left, right, root)
# compare the nodes, and return when the value is found in the left or the right sub branch.
# when both left and right subbranch returns a value, return it.
# traverse from the bottom till the root.

# recursive solution
# time complexity - O(n)
# space complexity - O(h)
# did this code successfully run on leetcode? - yes
# any issues faced? - no            

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def inorder(node):
            if not node:
                return None
            left = inorder(node.left)    
            right = inorder(node.right)
            curr_val = node.val
            if curr_val==p.val or curr_val==q.val or (left and right):
                return node
            elif left:
                return left
            elif right:
                return right
            else:
                return None
                
        return inorder(root)
    

# by maintaining list
# time complexity - O(n+h^2)
# space complexity - O(h) -- actual-O(h) recursive stack, O(2h) for the list, O(h) for the path  
# did this code successfully run on leetcode? - yes
# any issues faced? - no  
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.backtrack(root, p, q)
        
        for i in range(len(self.p)-1, -1, -1): # O(h^2)
            node = self.p[i]
            if node in self.q:
                return node
        return None
        
    def backtrack(self, root, p, q, path=[]):
        if not root:
            return 
        
        path.append(root)
        if root == p:
            self.p = path.copy()
        if root == q:
            self.q = path.copy()
        
        self.backtrack(root.left, p, q, path)
        self.backtrack(root.right, p, q, path)
        
        del path[-1]