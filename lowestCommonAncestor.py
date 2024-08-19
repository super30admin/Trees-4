# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """ 
    Time Complexity: O(N), where N is the number of nodes in the tree. 
    Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack.
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # If the root is None, there's no tree to search, so return None.
        if root == None:
            return root
        
        # Call the helper function dfs to find the LCA of nodes p and q.
        return self.dfs(root, p, q)

    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # If the current root is None, we've reached the end of a branch without finding the LCA, so return None.
        if root == None:
            return root
        
        # If both p and q are greater than the current root value, LCA must be in the right subtree.
        if root.val < p.val and root.val < q.val:
            return self.dfs(root.right, p, q)
        
        # If both p and q are less than the current root value, LCA must be in the left subtree.
        elif root.val > p.val and root.val > q.val:
            return self.dfs(root.left, p, q)
        
        # If p and q are on different sides of the root (or one of them is the root itself),
        # then the current root is the LCA.
        else:
            return root


################## Iterative Approach #####################
class Solution:
    """ 
    Time Complexity: O(N), where N is the number of nodes in the tree. 
    Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack.
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        while True:
            if root.val <p.val and root.val < q.val:
                root  = root.right
            elif root.val >p.val and root.val > q.val:
                root  = root.left
            else:
                return root
        return None
