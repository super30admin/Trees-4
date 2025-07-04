# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Get two paths for p and q and then compare both of them wherever there is uncomonality return.
# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         self.path_p = []
#         self.path_q = []
#         self.helper(root, [], p, q)
#         for i in range(len(self.path_p)):
#             if self.path_p[i] != self.path_q[i]:
#                 return self.path_p[i - 1] 
#     def helper(self, root, path, p, q):
#         if root == None:
#             return

#         path.append(root)
#         if root == p:
#             self.path_p = list(path)
#             self.path_p.append(root)
#         if root == q:
#             self.path_q = list(path)
#             self.path_q.append(root)

#         self.helper(root.left, path, p, q)
#         self.helper(root.right, path, p, q)

#         path.pop()



# CHECKING WITH LEFT AND RIGHT PASS

# Time complexity: O(n)
# Space complexity: O(h)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # if root is None it returns None and if it matches the value it returns the value
        if root == None or root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # Comparing the values from both the sides and returning accordingly
        if left == None and right == None:
            return None
        elif left == None and right != None:
            return right
        elif left != None and right == None:
            return left
        else:
            return root