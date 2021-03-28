# Created by Aashish Adhikari at 1:22 PM 3/26/2021

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Time Complexity:
O(k) where k the index of the element we want to find.

Space Complexity:
O(1) without considering the recursion stack under the hood, else O(logn) where n is the number of nodes in the tree and logn is the height of the tree.
'''

class Solution(object):

    def helper(self, node):

        # base case

        # logic
        if node.left is not None:
            self.helper(node.left)

        self.ctr += 1
        if self.ctr == self.k:
            self.sol = node.val
        else:
            # continue traversing to the right only if the current node is not the kth node
            if node.right is not None:
                self.helper(node.right)

    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """

        # If we traverse a binary search tree inorder, the kth node that we reach is the kth smallest node.


        self.ctr = 0
        self.k = k

        self.helper(root)

        return self.sol


