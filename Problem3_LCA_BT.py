#Problem 2:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
#Test Cases passed on Leetcode 
#Time Complexity:    O(n) 
#Space Complexity:   O(n)-recursive stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base
        if not root or root==p or root==q:
            return root
        #logic
        left=self.lowestCommonAncestor(root.left,p,q)
        print("left",left)
        right=self.lowestCommonAncestor(root.right,p,q)
        print("right",right)
        if left and right:
            return root
        elif left:
            return left
        elif right:
            return right
        else:
            return None