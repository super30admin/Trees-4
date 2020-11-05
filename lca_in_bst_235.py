# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        curr_node_val = root.val
        p_val = p.val
        q_val = q.val
        
        """
        3 cases arise:
        1) If p,q are in opposite directions - current root is the LCA
        2) if p,q are in left - call LCA in same direction recursivley
        3) if p.q are in right - call LCA in same direction recursivley
        """
        
        if p_val > curr_node_val and q_val > curr_node_val:
            return self.lowestCommonAncestor(root.right,p,q)
        
        if p_val < curr_node_val and q_val < curr_node_val:
            return self.lowestCommonAncestor(root.left,p,q)
        
        return root