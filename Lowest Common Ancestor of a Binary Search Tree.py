# Time complexity: O(h)
# Space complexity:O(1)
# Approach: Since its a BST, check if both values or lesser or greater than root
# if both are smaller, move left side of the tree else if larger, move right side of the tree
# if one is small or larger than the root or if the root's value is same as p or q- return root node


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        while True:
            if root.val > p.val and root.val > q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right  
            else:
                return root
        