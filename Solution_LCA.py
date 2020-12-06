"""
Time complexity O(log N)
Space complexity O(H)


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution_LCA:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base 
        if(root is None):
            return
   
        #Logic
        if(p.val<root.val and q.val<root.val):
            return self.lowestCommonAncestor(root.left,p,q)
        elif(p.val>root.val and q.val>root.val):
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root
        