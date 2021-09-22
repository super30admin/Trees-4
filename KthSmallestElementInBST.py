"""
Time Complexity : O(H + K) where H is the height of the tree and K is the node that we have to find
Space Complexity : O(H) where h is the height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        """self.count = 0
        self.result = -1
        if not root:
            return -1
        self.inorder(root, k)
        return self.result
    def inorder(self, root, k):
        # Base
        if not root:
            return
        # Logic
        self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        self.inorder(root.right, k)"""
        if not root:
            return -1
        s = []
        # We traverse through the nodes and append the leftmost nodes into to the 
        # stack. After that we pop the elements of the stack k times until k is zero
        # to get the kth largest element from the BST.
        while root != None or len(s) != 0:
            while root:
                s.append(root)
                root = root.left
            root = s.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        return -1
                