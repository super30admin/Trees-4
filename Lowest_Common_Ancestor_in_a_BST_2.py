# Created by Aashish Adhikari at 2:35 PM 3/26/2021

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

'''
Time Complexity:
O(n) where n is the number of nodes in the tree since in the worst case there could be only one child in each node.
In a balanced BST, it becomes O(logn).
Space Complexity:
O(1)
'''
class Solution(object):


    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        while root:


            if p.val < root.val and q.val < root.val:
                # if the current node's val is greater than both p and q, need to traverse right
                root = root.left
            elif p.val > root.val and q.val > root.val:
                # if the current node's val is smaller than both p and q, need to traverse left
                root = root.right
            else:
                # either 1. the node equals p or q and the other one is down below 2. or p and q are on different subtrees from this node and thus this node is the required LCA
                return root






