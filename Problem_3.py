"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem3 Lowest Common Ancestor of a Binary Tree
 (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

"""

# Approach - 1

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Using two list to maintain the path of p and q and keep checking the nodes. If the nodes not equal that means 
        we found our LCA
        Time Complexity : O(N)
        Space Complexity : O(H)

        """
        self.path_p = []
        self.path_q = []
        flag_p = False
        flag_q = False
        def helper(root, p, q, path):
            nonlocal flag_p
            nonlocal flag_q
            #Base Condition
            if root is None: return
            
            
            # Logic
            
            # Action
            path.append(root)
            
            if p == root:
                flag_p = True
                self.path_p = list(path)
                self.path_p.append(root)
            if q == root:
                flag_q = True
                self.path_q = list(path)
                self.path_q.append(root)
            
            
            # Recurse
            if not flag_p  or not flag_q:
                helper(root.left, p, q, path)
            if not flag_p  or not flag_q:
                helper(root.right, p, q, path)
            
            # Bactrack
            path.pop()
            
        helper(root, p, q, [])
        
        for i in range(len(self.path_p)):
            if self.path_p[i] != self.path_q[i]:
                return self.path_p[i -1]
            
        return None
        
# approach - 2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Bottom up recursion with same TC and SC
        """
        if root is None or p == root or q == root: return root
        
        left_node = self.lowestCommonAncestor(root.left, p, q)
        right_node = self.lowestCommonAncestor(root.right, p, q)
        
        
        if left_node is None and right_node is  None:
            return None
        
        elif left_node is not None and right_node is None:
            return left_node
        elif left_node is None and right_node is not None:
            return right_node
        else:
            return root
        