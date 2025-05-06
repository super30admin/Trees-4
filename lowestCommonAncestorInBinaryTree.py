import copy
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Time Complexity : O(N)
# Space Complexity : O(h)
# Approach:
# 1. Perform a depth-first search (DFS) to find the nodes p and q.
# 2. If we find either p or q, we return that node.
# 3. If we find both p and q in the left and right subtrees, we return the current node as the LCA.
# 4. If we find only one of p or q, we return that node.
# 5. If we find neither, we return None.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Helper function to perform DFS
        def dfs(node):
            # Base case: if the node is None, return None
            if not node:
                return
            # If we find either p or q, return the current node
            # This will also handle the case where p and q are the same node
            if node.val == p.val or node.val == q.val:
                return node
            # Recursively search in the left and right subtrees
            left = dfs(node.left)
            right = dfs(node.right)
            # If we find both p and q in the left and right subtrees, return the current node
            if left and right:
                return node
            # If we find only one of p or q, return that node
            if left:
                return left     
            else:
                return right
        # Start DFS from the root and return the result
        return dfs(root)

# Time Complexity : O(N)
# Space Complexity : O(N)
# Approach:
# 1. Perform a depth-first search (DFS) to find the nodes p and q.
# 2. If we find either p or q, we store the path to that node.
# 3. If we find both p and q, we compare the paths to find the last common node.
# 4. The last common node in the paths is the LCA.
# 5. If we find neither, we return None.
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Helper function to perform DFS and store the paths to p and q
        def dfs(node, path):
            if not node:
                return
            # Append the current node to the path
            path.append(node)
            # If we find either p or q, store the path
            if node.val == p.val:
                self.pathP.extend(path)
                self.pathP.append(node)
            if node.val == q.val:
                self.pathQ.extend(path)
                self.pathQ.append(node)
            # Recursively search in the left and right subtrees
            # If we find both p and q, we can stop searching
            if not self.pathP or not self.pathQ:
                dfs(node.left, path)
            if not self.pathP or not self.pathQ:
                dfs(node.right, path)
            # Backtrack by removing the current node from the path
            path.pop()
        # Initialize the paths to p and q
        self.pathP = []
        self.pathQ = []
        # Perform DFS to find the paths to p and q
        dfs(root, [])
        # Compare the paths to find the last common node
        # The last common node in the paths is the LCA
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]