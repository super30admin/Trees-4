
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.ans = float("inf")
        def inorder(root):
            if not root:
                return
            inorder(root.left)
            if root:
                self.k-=1
                if self.k==0:
                    self.ans = min(self.ans,root.val)
                    return
            inorder(root.right)
        inorder(root)
        return self.ans