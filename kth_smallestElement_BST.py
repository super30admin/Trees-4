#O(n) time and O(n) space solution
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        n = 0
        stack = []
        current = root
        while current or stack:
            while current:
                stack.append(current)
                current = current.left
                
            current = stack.pop()
            n += 1
            if n == k:
                return current.val
            current = current.right
