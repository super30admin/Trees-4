# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        """
        Approach:
        1. Use iterative in-order traversal with a stack, since in-order traversal of a BST returns values in sorted order.
        2. Traverse to the leftmost node, pushing nodes to the stack along the way.
        3. Pop from the stack one by one, counting until the kth element is found, then return its value.

        Time Complexity: O(H + k), where H = height of the tree (logN for balanced, N for skewed), and k is the position.
        Space Complexity: O(H), for the stack used in in-order traversal.
        """

        count = 0
        stack = []

        while root or stack:
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()
            count += 1

            if count == k:
                return root.val

            root = root.right
