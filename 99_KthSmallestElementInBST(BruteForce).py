'''
Accepted on leetcode(230)
Time - O(N)
Space - O(1)
Method: Do the inorder traversal of the tree and store it in list and then return kth element in the list.
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.li = []

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.inorder(root)
        return self.li[k - 1]

    def inorder(self, root):
        # Base Case
        if root is None: return

        # Logic
        self.inorder(root.left)
        self.li.append(root.val)
        self.inorder(root.right)