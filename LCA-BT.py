""" Time : O(logN)
    Space : O(1)
    Leetcode : Yes
    Explanation : There are 3 cases, either of the elements are in left or right subtree or is the middle element. If 2 of these 
    conditions are true, then we have a common ancestor as the current element. Or else, clearly the result is in either the left or right subtree.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def recurse_tree(root):
            
            if root is None:
                return False
            
            left = recurse_tree(root.left)
            right = recurse_tree(root.right)
            
            mid = root == p or root == q
                
            if mid + left + right >= 2:
                self.ans = root
                
            return left or mid or right

        recurse_tree(root)
        return self.ans
        