# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
		# Time Complexity : O(n) because we are traversing through all the elements of the tree
		# Space Complexity : Constant if we don't consider recursive stack
		# base case
		if root == None or root == p or root == q:
			return root
		left = self.lowestCommonAncestor(root.left, p, q)
		right = self.lowestCommonAncestor(root.right, p, q)
		if left != None and right != None:
			return root
		elif left != None:
			return left
		elif right != None:
			return right
		return None