# Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case, we may need to visit all nodes to find the lowest common ancestor.
# Space Complexity: O(H), where H is the height of the binary tree. In the worst case, the recursion stack can go as deep as the height of the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Initialize class variables to store the paths for nodes p and q.
    path_p = [TreeNode]  # This initialization is incorrect; it should be set to None.
    path_q = [TreeNode]  # This initialization is incorrect; it should be set to None.
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None  # Edge case.
        
        # Perform a backtracking search to find the paths for nodes p and q.
        self.backtrack(root, p, q, path=[])
        
        # Find the lowest common ancestor by comparing the paths of p and q.
        for i in range(len(self.path_p)):
            if self.path_p[i] != self.path_q[i]:
                return self.path_p[i-1]  # The LCA is the previous element in the path where they diverge.
        return None  # If the paths are identical or if p and q are not found, return None.
    
    def backtrack(self, root, p, q, path):
        # Base case: if the current node is None, return.
        if root is None:
            return
        
        # Add the current node to the path.
        path.append(root)
        
        # Check if the current node is p or q, and update the corresponding path.
        if root == p:
            self.path_p = path.copy()  # Update the path for node p.
            self.path_p.append(p)  # Add p to the end of the path (duplicate element for easier comparison later).
        if root == q:
            self.path_q = path.copy()  # Update the path for node q.
            self.path_q.append(q)  # Add q to the end of the path (duplicate element for easier comparison later).
        
        # Recur for the left and right subtrees.
        self.backtrack(root.left, p, q, path)
        self.backtrack(root.right, p, q, path)
        
        # Backtrack: remove the current node from the path.
        path.pop()
