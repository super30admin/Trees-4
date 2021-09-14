"""
//Time Complexity : O(Height)
// Space Complexity :O(Height) with recursion o(1) without recursion
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""



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
        #S.C = 0(1)
        #T.C = O(height)
        if root == None:
             return root
        while True:
            if root.val<p.val and root.val <q.val:
                root = root.right
            elif root.val>p.val and root.val >q.val:
                root = root.left  
            else:
                 return root
        #T. C = O(height of tree) if the tree is balanced then height is logn 
        #S.C = (height of tree)
        #base 
#         if root == None:
#             return root
#         if root.val<p.val and root.val <q.val:
#             return self.lowestCommonAncestor(root.right,p,q)
#         elif root.val>p.val and root.val >q.val:
#             return self.lowestCommonAncestor(root.left,p,q)
            
#         else:
#             return root
#wihtout recursion
      

        
        