# Time Complexity: O(h)
# Space Complexity: O(h)
# Approach: The LCA in a BST is the closest number to p.val and q.val. Recursively traverse the tree. If the node is > p and q, traverse right, if the node is < p and q, traverse left.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def dfs(node, p, q):
            if not node:
                return None
            
            if node.val > p.val and node.val > q.val:
                return dfs(node.left, p, q)
            
            if node.val < p.val and node.val < q.val:
                return dfs(node.right, p, q)
            
            return node
        
        if not root:
            return None
        
        return dfs(root, p, q)
            