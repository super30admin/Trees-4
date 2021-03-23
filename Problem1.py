# Time Complexity : O(k)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:

        self.k = k
        # res for storing the kth smallest value
        self.res = None
        # Initialzed flag so that when we have kth element then while recursing back we don't go to the right node
        self.flag = True
        if root:
            self.inorder(root)
            return self.res

            # Method for inorder traversal which will give recurse till kth element is found and then will recurse back

    def inorder(self, node):
        if node and self.flag:
            self.inorder(node.left)
            self.k -= 1
            if self.k == 0:
                self.res = node.val
                self.flag = False
                return
            self.inorder(node.right)