class Solution:
    def kthSmallest(self, root, k):
        self.count = 0
        self.result = None
        self.helper(root, k)
        return self.result.val

    def helper(self, root, k):
        if root is None:
            return
        if self.result is None:
            self.helper(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root
        if self.result is None:
            self.helper(root.right, k)

# Time: O(n)
# Space: O(h)