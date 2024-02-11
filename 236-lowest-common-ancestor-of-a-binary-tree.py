
"""
236. Lowest Common Ancestor of a Binary Tree
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 
Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1

 
Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.


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
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(1)
    
    Approach: The intuition is to find p or q while going down the tree.
        And return p or q if found. This result will travel upwarsd to the root
        - If the left and right subtrees return a non-null value, then the root is the LCA
        - If only one of the left or right subtree returns a non-null value, then the LCA is the non-null value
        - If both left and right subtrees return null, then the LCA is null | But this will never happen as p and q are guaranteed to be in the tree

    #NOTE: This is a bottom-up approach
        Here the values of p and q are not important, so we can solve this by returning boolean also
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root, p, q):
            #base
            if root is None or root == p or root == q: 
                return root
            right = helper(root.right, p, q)
            left = helper(root.left,p , q)
            if left != None and right != None:
                return root
            elif left:
                return left
            else:
                return right
        return helper(root, p, q)
    """
    Accepted
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(n) For the paths
    
    Approach: Do an inorder traversal to find the paths of the two nodes. Then compare the paths to find the LCA
    For example, if the paths are [3,5,6] and [3,5,2], then the LCA is 5
    
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        paths = []
        found = False
        def get_path(root, path, tgt):
            nonlocal found
            if root is None or found: # terminate if the node is None or if the target is found
                return
            path.append(root)
            if root.val == tgt:
                found = True
                paths.append(path.copy()) #found, save path
            else:
                get_path(root.left, path, tgt)
                get_path(root.right, path, tgt)
            path.pop()

        get_path(root, [], p.val)
        found = False
        get_path(root, [], q.val)
        
        def compare(lis1, lis2):
            # adding a copy of last node to the end of the list to easily handle edge cases
            # for ex: [3,5] and [3,5,2] => [3,5,5] and [3,5,2,2]. This will return 5, 
            # saving us from checking the last element as an edge case
            lis1.append(lis1[-1]) 
            lis2.append(lis2[-1]) 
            i, j = 0, 0
            while j < len(lis2) and i < len(lis1):
                if lis1[i].val != lis2[j].val:
                    return lis1[i-1]
                i += 1
                j += 1
            return None
        return compare(paths[0], paths[1])    

LeetCode(PROBLEM, Solution).check()
