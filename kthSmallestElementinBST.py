# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # iterative inorder traversal
    # TC : O(n)
    # SC : O(h)
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root is None:
            return -1
        st = []
        while root is not None or len(st) != 0:
            while root is not None:
                st.append(root)
                root = root.left
            root = st.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        return -1

        