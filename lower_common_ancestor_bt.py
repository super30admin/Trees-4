# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We traverse the tree while keeping track of the path and record the path whenever we encounter p or q. Finally we iterate through the path and return the last common node.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.path = []
        self.p_path = []
        self.q_path = []
        self.p = p
        self.q = q
        self.dfs(root)
        
        last_same = None
        for index in range(min(len(self.p_path), len(self.q_path))):
            if self.p_path[index] == self.q_path[index]:
                last_same = self.p_path[index]
            else:
                break
        return(last_same)
    
    def dfs(self, node):
        if node is None: 
            return
        self.path.append(node)
        if node == self.p:
            self.p_path = self.path.copy()
        if node == self.q:
            self.q_path = self.path.copy()
        if not self.p_path or not self.q_path:
            self.dfs(node.left)
            self.dfs(node.right)
        self.path.pop()
