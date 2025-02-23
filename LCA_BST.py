# Time Complexity : O(h)
# Space Complexity : O(h), recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# a node is allowed to be an ancestor of itself
# given two nodes - p and q
# if the value of root is < p and q => move right
# if the value of root is > p and q => move left
# else return root

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

        if root is None:
            return root
        
        while True:
        
            if root.val < p.val and root.val < q.val:
                root = root.right
            
            elif root.val > p.val and root.val > q.val:
                root = root.left
            
            else:
                return root
        

        