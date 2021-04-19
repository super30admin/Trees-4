# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def pqLCA(root):
            if root is None:
                return root
            
            if(root==p or root==q):
                return root
            # left/right will not be None if they have p and q
            left = pqLCA(root.left)
            right = pqLCA(root.right)
            if(left!=None and right!=None):
                return root
            elif(left!=None):
                return left
            else:
                return right
        return pqLCA(root)
