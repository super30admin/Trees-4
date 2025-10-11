# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time: O(k) to do an inorder traversal. Space: O(n). Logic is simple, do an inorder traversal until k times and once we reach kth smallest element return it.
class Solution:
    def kthSmallestRecursion(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = 0

        def helper(node, k):
            if not node:
                return
            helper(node.left, k)
            self.count += 1
            if self.count == k:
                self.result = node.val
            helper(node.right, k)

        helper(root, k)
        return self.result

    # Time and space is same as recursion approach. Here we are using explicit stack data structure and a while loop to do an inorder traversal
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st = []
        while st or root:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right