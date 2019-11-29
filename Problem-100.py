'''
Leetcode - Lowest Common Ancestor of a Binary Search Tree - 236 - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Time complexity -O(N)

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
         #base
        if root==None or root==p or root==q:
            return root
        
        #logic
        left=self.lowestCommonAncestor(root.left, p, q)
        right=self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        elif  left:
            return left
        elif right:
            return right
        else:
            return None
        
        