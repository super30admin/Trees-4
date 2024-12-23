class Solution:
    def __init__(self):
        self.pathP = []
        self.pathQ = []

    def lowestCommonAncestor(self, root, p, q):

        self.helper(root, p, q, [])

        # Now compare paths to find the LCA
        for i in range(min(len(self.pathP), len(self.pathQ))):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i - 1] if i > 0 else None
        return self.pathQ[-1] if len(self.pathQ) < len(self.pathP) else self.pathP[-1]

    def helper(self, root, p, q, path):
        if root is None:
            return

        # Add current node to the path
        path.append(root)

        # If root is p, save the path
        if root == p:
            self.pathP = list(path)

        # If root is q, save the path
        if root == q:
            self.pathQ = list(path)

        # Recurse for left and right children
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)

        # Backtrack, remove the last element
        path.pop()
