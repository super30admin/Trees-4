# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time : O(n)
# Space: O(n)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return None
        if p == root or q == root:
            return root
        left_rec = self.lowestCommonAncestor(root.left, p, q)
        right_rec = self.lowestCommonAncestor(root.right, p, q)
        if left_rec != None and right_rec != None:
            return root
        elif left_rec != None:
            return left_rec
        else:
            return right_rec
        
