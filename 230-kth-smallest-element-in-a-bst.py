
"""
230. Kth Smallest Element in a BST
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 
Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

 
Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

 
Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Accepted
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(h) recursive stack space
    
    Approach:
    - We can use an inorder traversal to solve this problem. We can use a counter to keep track of the kth smallest element
    
    """
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = k
        res = 0
        def dfs(root): #inorder traversal
            nonlocal count
            nonlocal res
            if root is None or count == -1:
                return
            dfs(root.left)
            count -= 1 #decrease every time we visit a node
            if count == 0: 
                res = root.val
                count = -1 #flag
                return
            dfs(root.right)
        dfs(root)
        return res # will be kth element in inorder traversal which is sorted

LeetCode(PROBLEM, Solution).check()
