# APPROACH  1: BACKTRACKING
# Time Complexity : O(n), n: number of node
# Space Complexity : O(n), size of the paths
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Get the path for both p and q using backtracking
# 2. Keep appending the nodes to the path till you reach p / q. Add p / q twice to path for ease of comparison. At each node, recurse on both left and right. Stop when the 
#    last node in the path is p / q
# 3. Compare the paths of both the nodes and lowest common ancestor is that node (last common one between the two lists)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root is None:
            return None
        
        path_p, path_q = [], []
        
        self.backtrack(root, p, path_p)
        self.backtrack(root, q, path_q)
        
        for ind in range(len(path_p)):
            if path_p[ind] != path_q[ind]:
                return path_p[ind - 1]
            
        return None
    
    def backtrack(self, root, node, path):
        if root is None:
            return None
        
        if root == node:
            path.append(root)
            
        path.append(root)
        
        self.backtrack(root.left, node, path)
        if path[-1] == node:
            return
        
        self.backtrack(root.right, node, path)
        if path[-1] == node:
            return
        
        path.pop()
        



# APPROACH  2: DFS
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Traverse tree in DFS - return curr root when it equals p / q
# 2. Lowest common ancestor is that node whose subtree's recursion send s back p / q
# 3. Lowest common ancestor can also be p or q 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root is None or root.val == p.val or root.val == q.val:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left is not None and right is not None:
            return root
        
        elif left is not None:
            return left
        
        elif right is not None:
            return right
        
        else:
            return None
