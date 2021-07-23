from copy import deepcopy


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    Approach 1: DFS with backtracking
    1) identify the paths for both nodes and compare
    2) the lastest same node for both paths is the ancestor

    TC: O(n)
    SC: O(h)
    """

    def __init__(self):
        self.path1 = []
        self.path2 = []

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.backtrack(root, p, q, [])
        for i in range(len(self.path1)):
            if self.path1[i].val != self.path2[i].val:
                return self.path1[i - 1]
        return

    def backtrack(self, root, p, q, path_track):
        # base
        if not root:
            return

        if root == p:
            self.path1 = deepcopy(path_track)
            self.path1.append(p)
            self.path1.append(p)

        if root == q:
            self.path2 = deepcopy(path_track)
            self.path2.append(q)
            self.path2.append(q)

        # logic
        path_track.append(root)  # action
        if not self.path1 or not self.path2:
            self.backtrack(root.left, p, q, path_track)
        if not self.path1 or not self.path2:
            self.backtrack(root.right, p, q, path_track)
        path_track.pop()  # backtrack

    """
    Approach 2: Bottom up
    at each node, get the left and right node and decide the LCA
    TC: O(n)
    SC: O(h)
    """

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return root
        if root == p or root == q:
            return root

        left_node = self.lowestCommonAncestor(root.left, p, q)
        right_node = self.lowestCommonAncestor(root.right, p, q)

        if left_node and right_node:
            return root
        elif left_node:
            return left_node
        elif right_node:
            return right_node
        else:
            return
