
"""
235. Lowest Common Ancestor of a Binary Search Tree
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 
Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2

 
Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    Accepted
    Time Complexity: O(h) == O(log(n)) where h is the height of the tree || BST property
    Space Complexity: O(h) recursive stack space
    
    Approach: The intuition is to find the diverging point of the two nodes. 
        - At any point if p and q should be belon on either side of the root. THis is the point where the two nodes diverge and the LCA
        - Othwerwise, both p and q are on the same side of the root. In this case, we can traverse to the left or right subtree of the root
        - Also, if root is equal to any of the nodes, then root is the LCA
        
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root, p, q):
            if p.val > root.val and q.val > root.val:
                root = root.right
            elif p.val < root.val and q.val < root.val:
                root = root.left
            else:
                print("hit")
                return root #base caser
            return dfs(root,p,q)
        return dfs(root,p,q)

LeetCode(PROBLEM, Solution).check()
