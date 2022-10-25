# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    first = 0
    second = 0
    flag = False

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return

        self.inorder(root)

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self, root):
        print(root)
        st = []
        prev = None
        while root or st:
            while root:
                st.append(root)
                # print(st)
                root = root.left
            root = st.pop()
            # print(st)
            if prev and prev.val >= root.val:
                if not self.flag:
                    self.first = prev
                    self.second = root
                    self.flag = True
                else:
                    self.second = root
            print(root)
            prev = root
            root = root.right

# Stack Solution
# Time Complexity : O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
