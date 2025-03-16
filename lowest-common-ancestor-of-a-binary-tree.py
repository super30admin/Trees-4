# Backtracking solution to generate paths of both p and q and return when there is mismatch in the paths
# TC : O(n)
# SC : O(h)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        self.path_p = []
        self.path_q = []
        self.backtrack(root, p, q, [])

        for i in range(0,len(self.path_p)):
            if self.path_p[i] != self.path_q[i]:
                return self.path_p[i-1]

    def backtrack(self, root, p, q, path):
        if root is None:
            return

        path.append(root)
        if root == p:
            self.path_p = list(path)
            self.path_p.append(root)
        if root == q:
            self.path_q = list(path)
            self.path_q.append(root)
        self.backtrack(root.left, p, q, path)
        self.backtrack(root.right, p, q, path)
        path.pop()


# Bottom up solution
# TC : O(n)
# SC : O(h)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        if root is None or root is p or root is q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None:
            return None

        elif left is None and right is not None:
            return right

        elif right is None and left is not None:
            return left

        else:
            return root

