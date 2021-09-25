# Time Complexity: O(n), where n - number of nodes in the tree
# Space Complexity: O(h), where h - height of the tree

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return -1

        stack = []

        # Inorder traversal in BST gives sorted order and kth node from the left gives the kth smallest element
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right

        return -1
