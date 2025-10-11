# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time complexity: O(n) traversing to find the value of p and q. Space: (n) as well for recursion depth, pathP and pathQ.
# The logic here is to find the path of P and Q respectively and then check at which element they don't match. Return the previous element as that will be the LCA
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        pathP = None
        pathQ = None

        def helper(node, path):
            nonlocal pathP, pathQ
            if not node:
                return
            path.append(node)
            if node == p:
                pathP = path.copy()
                pathP.append(p)
            if node == q:
                pathQ = path.copy()
                pathQ.append(q)
            if pathP is None or pathQ is None:
                helper(node.left, path)
            if pathP is None or pathQ is None:
                helper(node.right, path)
            path.pop()

        helper(root, [])
        p1 = 0
        p2 = 0
        for i in range(len(pathP)):
            if pathP[i] != pathQ[i]:
                return pathP[i - 1]

    #Time: O(n) and space: O(n) recursion depth stack, however, we don't have to keep track of path anymore here. The logic is to go left and right and search for p and q
    # If we find them then we return root(either p or q) and from the others where we don't find them we return null. Eventually at a given point we will be able to determine the LCA
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if not root or root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)

        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None:
            return None
        elif left is not None and right is None:
            return left
        elif left is None and right is not None:
            return right
        else:
            return root