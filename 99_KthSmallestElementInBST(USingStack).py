'''
Accepted on leetcode(230)
Time - O(H+k)
Space - O(H+k)

'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st = []
        while True:
            while root != None:
                st.append(root)
                root = root.left

            root = st.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
