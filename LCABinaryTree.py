# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time Complexity: O(n)
#Space Complexity : O(height(Tree))
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if(root == None):
            return
        if(root == p or root == q):
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if(left == None and right == None):
            return None
        elif(left != None and right == None):
            return left
        elif(left != None and right != None):
            return root
        else:
            return right
        
