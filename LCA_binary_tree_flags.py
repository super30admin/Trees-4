# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base
        # return whatever you find for the current node back to the branch where it was called from
        if(root == None or root == p or root == q):
            return root
        
        # logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # when both left and right have values, then we have found common parent
        if(left != None and right != None):
            return root
        # 
        elif(left != None):
            return left
        elif(right != None):
            return right
        # else:
        #     return None