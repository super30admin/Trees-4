# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
		# Time Complexity : O(logn) because we are only searching on one half. At every step we are discarding one half of the problem.
		# Space Complexity : Constant space
		if root.val > p.val and root.val > q.val:
			return self.lowestCommonAncestor(root.left, p, q)
		elif root.val < p.val and root.val < q.val:
			return self.lowestCommonAncestor(root.right, p, q)
		else:
			return root

	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
		# Iterative approach to solve the same problem
		# Time Complexity : O(logn) because we are only searching on one half. At every step we are discarding one half of the problem.
		# Space Complexity : Constant space
		# Only problem is we will lose the pointer to the root. So we can use a temp to point to root and use that to find the common ancestor.
		while root:
			if root.val > p.val and root.val > q.val:
				root = root.left
			elif root.val < p.val and root.val < q.val:
				root = root.right
			else:
				return root