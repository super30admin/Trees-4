# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def lowestCommonAncestor(self, root, p, q) :
        #     Check for root and if not return none
        if not root:
            return None
        #         check if any of the value in q or q is root val we will return root
        if root and (root is p or root is q):
            return root
        #         else we will iterate over left subtree and right subtree
        #  if both are not null we will return root as they will be on either
        #  side of the root, else if any one of the will be return whichever is not null worst case will return None
        else:

            ls = self.lowestCommonAncestor(root.left, p, q)

            rs = self.lowestCommonAncestor(root.right, p, q)

            if ls and rs:
                return root
            if ls:
                return ls
            if rs:
                return rs
            else:
                return None