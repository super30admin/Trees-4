'''
1. We are using the property of binary search in a BST to identify the root node for which both p and q are children or one of them is a root.
2. We begin by checking if root is greater than both the nodes, in that case our nodes definitely lie on left of the tree, so go left.
3. In case root is less than both the values go right. 
4. Else we have root as one of the values and other is in that subtree (or) both in the subtree so least ancestor is the root.

TC: O(h)
SC: O(1) 
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if not root:
            return root

        while True:
            if root.val > p.val and root.val > q.val:
                root = root.left
            
            elif root.val < p.val and root.val < q.val:
                root = root.right
            
            else:
                return root
            
        