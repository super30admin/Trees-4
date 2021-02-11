'''
    Time Complexity:
        O(h + k) (where h = height of the tree)

    Space Complexity:
        O(h) (where h = height of the tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        DFS approach.
        -> Traverse the tree in InOrder fashion.
        -> If k is 0, set the your output value to root.val and get out of recurssion.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.k = 0
        self.val = -1

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.k = k
        self.find_node(root)

        return self.val

    def find_node(self, root):
        if not root:
            return

        if self.val != -1:
            return

        self.find_node(root.left)
        self.k -= 1
        if self.k == 0:
            self.val = root.val
            return

        self.find_node(root.right)
