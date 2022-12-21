# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#TC: O(n)
#SC: O(h)

#Accepted on Leetcode

#Approach
#Use a bottoms-up recursion approach -> for each node call LST and RST, each call checks if p and q are present on the side being called
#If p and q are present on different sides, we know the current node is the least common ancestor, if only one of them is present (on left or right), pass that value up so as to find the LCA. If neither is present, pass null upwards to indicate p + q are both not in this subtree
#If we hit base case (p found, q found or null), return whatever the root is to indicate that base case has been hit



class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.lca(root, p, q)

    def lca(self, root, p, q):
        #base case
        if root == None or root == p or root == q:
            return root

        #logic
        left = self.lca(root.left, p, q)
        right = self.lca(root.right, p, q)

        if left == None and right == None:
            return None
        if left == None and right != None:
            return right
        if left != None and right == None:
            return left
        return root





