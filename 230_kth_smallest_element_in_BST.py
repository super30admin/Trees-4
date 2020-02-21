# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        """
            Time Complexity - O(k)
            Space Complexity - O(h)
            'h' is the height of the tree
        """
        # edge case
        if not root:
            return -1
        # inorder traversal
        # LDR
        stack = []
        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                cur = stack.pop()
                k -= 1
                if k == 0:
                    return root.val
                root = cur.right

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return -1
        self.result = None
        self.k = k
        self._inorder_traveral(root)
        return self.result

    def _inorder_traveral(self, root):
        # base
        if not root:
            return
        # logic
        self._inorder_traveral(root.left)
        self.k -= 1
        if self.k == 0:
            self.result = root.val
            return
        self._inorder_traveral(root.right)
