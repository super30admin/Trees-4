'''
Solution:
1.	Using Recursion, when both p and q values are less than root -> recurse left;
	when both of them are greater than root -> recurse right;
	otherwise return root.
2.	Using Iteration, instead of recursing, just update root to root.left ot root.right
	based on same conditions; otherwise return root itself.

Time Complexity:    O(h) in both the cases, where h is the height of the tree.
Space Complexity:   O(h) in recursion and O(1) in iteration, where h is the height of the tree.

--- Passed all testcases successfully on Leetcode.
'''


# Definition for a binary tree node.
class TreeNode:

	#   definition of TreeNode
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LCA_BST_Recursion:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        #	base case
        if (root == None):
            return root
        
        #	if both are lesser to root -> recurse left
        if (p.val < root.val and q.val < root.val):
            return self.lowestCommonAncestor(root.left, p, q)

        #	if both are greater to root -> recurse right
        elif (p.val > root.val and q.val > root.val):
            return self.lowestCommonAncestor(root.right, p, q)

        #	if one is smaller and one is larger -> return root itself
        else:
            return root


class LCA_BST_Iteration:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        #	base case
        if (root == None):
            return root
        
        #	iterate until root is Null
        while (root != None):

        	#	if both are lesser to root -> update root to its left
            if (p.val < root.val and q.val < root.val):
                root = root.left

            #	if both are greater to root -> update root to its right
            elif (p.val > root.val and q.val > root.val):
                root = root.right

            #	if one is smaller and one is larger -> return root
            else:
                return root
        #	return root if out of the loop
        return root