# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted on leetcode
#Time complexity - O(N) as we traverse every node
#Space omplexity - O(1)

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #edge case
        if root == None:
            return None
        #If anyone of nodes p or q is root, return root
        if root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        if left != None and right != None:
            return root
        
        if left == None and right == None:
            return None
        
        if left != None:
            return left
        else:
            return right