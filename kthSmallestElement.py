"""
TC - O(h)
SC - O(h) - since we do not generate new call but the recursive stack needs to be completed
"""
class Solution:
    def kthSmallest(self, root, k):
        self.k = k
        self.res = None
        self.inorder(root)
        return self.res

    def inorder(self, node):
        if not node:
            return
        self.inorder(node.left)
        self.k -= 1
        if self.k == 0:
            self.res = node.val
            return
        self.inorder(node.right)