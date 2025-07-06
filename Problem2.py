"""
I implemented this using the properties of a Binary Search Tree (BST). If both nodes are smaller than the root, I move to the left subtree. If both are greater, I move to the right subtree. Otherwise, the current node is where the split occurs - that's the Lowest Common Ancestor.
Time Complexity: O(h)
Space Complexity: O(h)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        
        if root is None:
            return None

        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)

        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)

        else:
            return root