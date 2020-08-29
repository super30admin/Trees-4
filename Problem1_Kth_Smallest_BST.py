#Problem 2: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
#Test Cases passed on Leetcode 
#Time Complexity:    O(logn) since we are rejecting half of the nodes in the BST
#if it would have been a skewed tree then it would be O(n)
#Space Complexity:   O(n)-recursive stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
        	#check if p and q lies in left of root, then we'll find ancestor at left
            if root.val>p.val and root.val>q.val:
                return self.lowestCommonAncestor(root.left,p,q)
            #check if p and q lies in right of root, then we'll find ancestor at right
            elif root.val<p.val and root.val<q.val:
                return self.lowestCommonAncestor(root.right,p,q)
            #otherwise there could be 2 cases:
            # Case 1: when one is greater than root and other is less than root , that is one is in right and other is in left
            # Case 2: when root is one of p or q , then we need to return root
            else:
                return root