# Time Complexity: O(N)
# Space Complexity: O(k)
# Approach: Inorder DFS. Keep a track of the number of inorder predecessors during DFS. If the number of predecessors == k, return.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        # Initialize kth as an object (or global)
        kth = [0]

        # DFS returns nuber of predecessors before the node
        def dfs(node, numpred):
            if node.left:
                numpred = dfs(node.left, numpred)

            numpred += 1
            if numpred == k:
                # Found kth, terminate DFS early
                kth[0] = node.val
                return numpred

            if node.right:
                numpred = dfs(node.right, numpred)

            return numpred

        dfs(root, 0)
        return kth[0]
