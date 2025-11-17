# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.result = None
        def inorder(root):
            if not root:
                return

            preorder(root.left)
            self.k -= 1

            if self.k == 0:
                self.result = root.val
                return

            #print(root.val, self.k)
            
            preorder(root.right)

            return
        inorder(root)
        return self.result
