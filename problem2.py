# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(node,p,q):
            if node:
                #if any one of the node is equal then return that node, this is the case when one node is ancestor of other
                if node==p or node==q:
                    return node
                #if the diversion is from current node, then this is ancestor
                if (node.val<p.val and node.val>q.val) or (node.val>p.val and node.val<q.val):
                    return node
                left=helper(node.left,p,q)
                right=helper(node.right,p,q)
                
                if left==None and right!=None:
                    return right
                if left!=None and right==None:
                    return left
        return helper(root,p,q)
        #Time O(n)
        #Space O(n)
                    
            
