# Created by Aashish Adhikari at 4:53 PM 3/28/2021

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

'''
Time Complexity:
O(n) where n is the number of nodes in the tree.

Space Complexity:
O(height of the tree) ~ O(logn)
'''
class Solution(object):


    def helper(self, node, p, q):


        if node is None:
            return False, False

        FOUND_P = False
        FOUND_Q = False

        if node == p:
            FOUND_P = True
        if node == q:
            FOUND_Q = True

        p_left, q_left, p_right, q_right = False, False, False, False

        if node.left is not None:
            p_left, q_left = self.helper(node.left, p, q)

        if node.right is not None:
            p_right, q_right = self.helper(node.right, p, q)

        if (p_left or p_right or FOUND_P) and (q_left or q_right or FOUND_Q):
            self.sol = node

            # NOW TO MAKE SURE THAT THE OTHER ANCESTORS DONT GET MARKED AS LCA, RETURN FALSE REGARDLESS FOR ALL THE ANCESTORS
            return False, False
        else:
            return p_left or p_right or FOUND_P, q_left or q_right or FOUND_Q



    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        self.sol = None
        self.helper(root, p, q)

        return self.sol
