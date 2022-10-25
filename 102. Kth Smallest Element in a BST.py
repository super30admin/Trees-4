# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # st = []
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # if root is None:
        #     return

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

        return -1

# Iterative
# Time Complexity: O(n)
# Space Complexity: O(n)
