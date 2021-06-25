# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        
        if root is None:
            return None 
        
        if root.val == p.val or root.val == q.val:
            return root
        
        left_lca = self.lowestCommonAncestor(root.left,p,q)
        right_lca = self.lowestCommonAncestor(root.right,p,q)
        
        if left_lca!= None and right_lca!= None:
            return root
        
        if left_lca == None and right_lca == None:
            return None
        
        if left_lca!= None:
            return left_lca
        
        return right_lca
        
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        