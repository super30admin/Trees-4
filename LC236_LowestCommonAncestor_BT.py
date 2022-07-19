"""
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

M1 (Top Down)
We do a DFS traversal and store the path upto both the nodes to be searched for
When the path nodes become different, one node before that is the LCA

In case of unequal paths, whichever path finishes first, the last node will be the LCA
OR to get rid of unequal paths/ index out of bounds, we append the leaf node twice in both the paths

TC = O(n)
SC = O(h) - 2 arrays for storing path 

M2(Bottom Up) : we will not need extra space in this case

At each and every node we will maintain 2 things, left and a right pointer
We will recursively call the func on left and right child, and return the node to the parent when found.

If both left and right calls are not returning null, it means that the parent is the LCA 

TC = O(h)
SC = O(1)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left == None and right == None:
            return None
        elif left ==None and right!=None:
            return right
        elif left!=None and right == None:
            return left
        else:
            return root
        
