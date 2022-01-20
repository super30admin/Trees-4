class Solution:
    def kthSmallest(self, root, k: int) -> int:
        # Time Complexity - O(n)
        # Space Complexity - O(h) where h is the height. The space if for the recursive stack
        n = 0
        stack = []
        cur = root

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left

            cur = stack.pop()
            n += 1
            if n == k:
                return cur.val

            cur = cur.right