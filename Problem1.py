"""
Implemented using recursive inorder traversal of BST. Since inorder traversal of a BST gives nodes in sorted order, we keep a counter to track how many nodes have been visited. Once we reach the kth node, we store the result and stop further traversal.
Time Complexity: O(k) 
Space Complexity: O(h)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:

        self.count = 0
        self.res = None
        self.flag = False

        def inorder(node):
            if node is None or self.flag:
                return

            inorder(node.left)
            self.count += 1
            if self.count == k:
                self.res = node.val
                self.flag = True
                return

            inorder(node.right)

        inorder(root)
        return self.res