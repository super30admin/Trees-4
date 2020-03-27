'''
Iterative:
Time Complexity: O(log n)
Space Complexity: O(log n)
Did this code successfully run on Leetcode : Yes
Explanation : 2 solutions recursive and iterative.
For recursive: We check if p<root and q<root then go left subtree, if p>root and q>root the go to right subtree, else root
is the LCA
For iterative: Same as above but use a while loop to go to the left most subtree and right most subtree based on above conditions
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if root == None:
            return root

        while root != None:
            # p,q<root traverse left
            if p.val < root.val and q.val < root.val:
                root = root.left

            # p,q>root traverse right
            elif p.val > root.val and q.val > root.val:
                root = root.right

            # otherwise just return root
            else:
                return root

    def lowestCommonAncestorIterative(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return root

        # p,q<root traverse left
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)

        # p,q>root traverse right
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)

        # otherwise just return root

        return root