// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we traverse through each and every node in the tree and check the left and right tree if any of the given nodes are present or not.For a given node if both left and right nodes are the same as the given nodes then return the root.

# Recursion
# Time complexity --> o(n) n is the total number of nodes in the tree
# space complexity -->o(h) --> h is the height of the tree
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
        if root==None:
            return None
        if root.val==p.val:
            return root
        if root.val==q.val:
            return root
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        if left!=None and right!=None:
            return root
        elif left==None and right!=None:
            return right
        else:
            return left