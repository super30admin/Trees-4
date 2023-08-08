"""
Problem : 1

Time Complexity : O(logn)
Space Complexity : 
Iterative - O(1)
Recursive - O(h) //h=height of tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Lowest Common Ancestor of a Binary Tree

# Approach - 2
# Iterative

class Solution(object):
    def __init__(self):
        self.pathP=[]
        self.pathQ=[]
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root.val>p.val and root.val>q.val:
            root=root.left
            self.lowestCommonAncestor(root.left,p,q)
        elif root.val<p.val and root.val<q.val:
            self.lowestCommonAncestor(root.right,p,q)
            root=root.right
        else:    
            return root

# Approach - 2
# Recursive
class Solution(object):
    def __init__(self):
        self.pathP=[]
        self.pathQ=[]
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        while True:
            if root.val>p.val and root.val>q.val:
                root=root.left
            elif root.val<p.val and root.val<q.val:
                root=root.right
            else:    
                return root
            
