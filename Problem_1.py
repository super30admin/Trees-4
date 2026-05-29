class Solution:
    # def kthSmallest(self, root, k):
    #     self.sorted = []
    #     self.inorder(root)
    #     return self.sorted[k - 1].val

    # def inorder(self, root):
    #     if not root:
    #         return
    #     self.inorder(root.left)
    #     self.sorted.append(root)
    #     self.inorder(root.right)

    def kthSmallest(self, root, k):
        self.sorted = []
        self.inorder(root, k)
        return self.sorted[-1].val

    def inorder(self, root, k):
        if not root:
            return
        self.inorder(root.left, k)
        print(root.val)
        if len(self.sorted) == k:
            return
        self.sorted.append(root)
        if len(self.sorted) < k:
            self.inorder(root.right, k)