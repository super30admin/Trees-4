# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root: return 

        if p.val > q.val: 
            p, q = q, p

        def traverse(node, p, q):
            if not node: 
                return None


            if p.val < node.val and q.val < node.val: 
                val = traverse(node.left, p, q)
                if node is not None: 
                    return val

            if p.val > node.val and q.val > node.val: 
                val = traverse(node.right, p, q)
                if node is not None: 
                    return val

            if p.val <= node.val <= q.val: 
                return node

        return traverse(root, p, q)


