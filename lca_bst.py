class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.pathP = None
        self.pathQ = None

    def lowestCommonAncestor(self, root, p, q):
        self.helper(root, p, q, [])

        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]

        return None

    def helper(self, root, p, q, path):
        if root is None:
            return

        path.append(root)

        if root == p:
            self.pathP = list(path)
            self.pathP.append(root)

        if root == q:
            self.pathQ = list(path)
            self.pathQ.append(root)

        if self.pathP is None or self.pathQ is None:
            self.helper(root.left, p, q, path)

        if self.pathP is None or self.pathQ is None:
            self.helper(root.right, p, q, path)

        path.pop()

# Time: O(n)
# Space: O(h)