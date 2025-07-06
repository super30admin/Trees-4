#Time Complexity: O(h+k)
#Space Complexity: O(h), h is teh height of the tree
# class Solution(object):
#     def kthSmallest(self, root, k):
#         """
#         :type root: Optional[TreeNode]
#         :type k: int
#         :rtype: int
#         """
#         #add all elemnets to a list using DFS
#         # using min heap to get the Kth smallest elemnet
#         res = []
#         def dfs(root):
#             if root is None:
#                 return
#             dfs(root.left)
#             res.append(root.val)
#             dfs(root.right)
#         dfs(root)
#         print(res)
#         return res[k-1]

class Solution(object):
    def kthSmallest(self, root, k):
        self.k = k
        self.result = None

        def inorder(node):
            if not node or self.result is not None:
                return
            inorder(node.left)
            self.k -= 1
            if self.k == 0:
                self.result = node.val
                return
            inorder(node.right)

        inorder(root)
        return self.result


