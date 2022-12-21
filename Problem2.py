# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#TC: O(n)
#SC: O(1)

#Accepted on Leetcode

#Approach
#Use BST property -> we know LST is composed of values smaller than current node and rst is composed of values larger
#Till p and q are both situated in a single direction WRT to current root -> keep traversing (decide using value of root, p, q)
#As soon as p and q are present in LST and RST (or vice versa) => We know they diverge at the current root which will be the lowest common ancestor

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True:
            if root.val > p.val and root.val > q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root