from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Approach 1: DFS - iterative in order
    TC: O(h + k) --> O(n) worst case
    SC: O(h)
    """

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = deque()
        curr = root
        while stack or curr:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()

            # logic
            k -= 1
            if k == 0: return curr.val
            curr = curr.right
        return

    """
    Approach 2: DFS recursive
    TC: O(n)
    SC: O(h)
    """

    def __init__(self):
        self.count = 0
        self.result = None

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.inorder(root, k)
        return self.result

    def inorder(self, root, k):
        # base
        if not root:
            return

        # logic
        self.inorder(root.left, k)
        self.count += 1
        if k == self.count:
            self.result = root.val
            return
        self.inorder(root.right, k)

    """
    Followup - if the same operation needs to be done frequently:
    1) in the constructor, traverse through all nodes and identify number of nodes on left and right of each node
    2) based on this count you can do a binary search find of an approach

    """