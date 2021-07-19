# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        SC:O(1)
        TC:O(h), h=height of tree
        """
        iterative 
        cur=root
        while cur:
            if p.val>cur.val and q.val>cur.val:
                cur=cur.right
            if p.val<cur.val and q.val<cur.val:
                cur=cur.left
            else:
                return cur
        
       
    # recursive
#         """
#         SC:O(h)
#         TC:O(h)
#         """
        
#         if root.val<p.val and root.val<q.val: return lowestCommonAncestor(root.right,p,q)
         
#         elif root.val>p.val and root.val>q.val: return lowestCommonAncestor(root.left,p,q)
#         else:
#             return root
        
        
        