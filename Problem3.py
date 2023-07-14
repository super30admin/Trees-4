'''
Problem:  Lowest Common Ancestor of a Binary Tree
Time Complexity: O(n), n is number of nodes
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
       Applied bottom up recursion
       children returns correct ancestor to parent
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Bottom Up Recursion
        if root is None or root == p or root==q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left ==  None and right == None:
            return None
        elif left == None and right != None:
            return right
        elif left !=None and right == None:
            return left
        else:
            return root

            
        