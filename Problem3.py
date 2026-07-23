## Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # TIME COMPLEXITY: O(N), where N is the number of nodes in the tree. 
        # In the worst case, the DFS will visit every node exactly once to find both p and q.
        #
        # SPACE COMPLEXITY: O(H), where H is the height of the tree. 
        # This accounts for the recursion stack and the memory used to store `pathP` and `pathQ`.
        # In a perfectly balanced tree, H = log(N) making space O(log N).
        # In the worst case (a skewed tree), H = N making space O(N).
        
        pathP, pathQ = [], []
        def dfs(root, path):
            # Base case: if the current node is None, backtrack.
            if not root:
                return
            
            # Add the current node to the tracking path
            path.append(root)
            
            # Logic: If we encounter 'q', store a deep copy of the current path
            if root.val == q.val:
                pathQ.append(list(path))
                
            # Logic: If we encounter 'p', store a deep copy of the current path
            if root.val == p.val:
                pathP.append(list(path))
            
            # Recursively explore the left and right subtrees
            dfs(root.left, path)
            dfs(root.right, path)
            
            # Backtrack: remove the current node from the path as we go back up the tree
            path.pop()
        
        # Initiate the DFS starting at the root with an empty path
        dfs(root, [])
        
        # Extract the single matched path for both p and q
        pathP = pathP[0]
        pathQ = pathQ[0]
        
        # Find the minimum length between the two paths to prevent index out of bounds
        n = min(len(pathP), len(pathQ))
        i = 0
        
        # Iterate through both paths simultaneously to find where they diverge
        while i < n:
            if pathP[i].val != pathQ[i].val:
                # The last common node before divergence is the lowest common ancestor
                return pathP[i - 1]
            i += 1
        
        # If the loop finishes without diverging, one node is an ancestor of the other. 
        # The lowest common ancestor is the last evaluated node.
        return pathP[i - 1]