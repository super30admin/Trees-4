# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
Tc: O(n)
Sc- O(n)"""

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root, p, q)
    def helper(self, node, p, q):

        ##no node to process
        if node==None:
            return None

        ##if this is the node we are looking for
        if node==p or node==q:
            return node

        ##if this is not the node we are looking for,
        ###need to go down
        leftSubtree=self.helper(node.left,p,q)
        rightSubtree=self.helper(node.right, p,q)

        if leftSubtree is None:
            return rightSubtree
        if rightSubtree is None:
            return leftSubtree

        return node
        