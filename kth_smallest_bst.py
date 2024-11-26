# Tiem complexity - O(n)
# Spacecomplexity - O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        ans = None
        def inorder(root):
            nonlocal ans, k
            if root:
                inorder(root.left)
                k -= 1
                if k == 0:
                    ans = root.val
                if k:
                    inorder(root.right)
        inorder(root)
        return ans
