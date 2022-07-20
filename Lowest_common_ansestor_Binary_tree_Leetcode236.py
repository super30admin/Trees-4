# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Recursion - keeping path SC - O(h)
    # TC = O(n)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.path_p = None
        self.path_q = None
        self.helper(root, p, q, [])

        for i in range(len(self.path_p)):
            if self.path_p[i] != self.path_q[i]:
                return self.path_p[i - 1]
        return None

    def helper(self, root, p, q, path):
        # base
        if not root:
            return

        path.append(root)

        if root == p:
            self.path_p = path.copy()
            self.path_p.append(p)

        if root == q:
            self.path_q = path.copy()
            self.path_q.append(q)

        # logic
        # action
        # recurse
        self.helper(root.left, p, q, path)

        self.helper(root.right, p, q, path)
        # backtrack
        path.pop()

    '''
        # Bottom up recursion
        # TC - O(n)
        # SC - O(h) recursion stack
        #base
        if root == None or root == p or root == q:
            return root
        #logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left == None and right == None:
            return None
        elif left != None and right == None:
            return left
        if left == None and right != None:
            return right
        if left != None and right != None:
            return root
    '''











