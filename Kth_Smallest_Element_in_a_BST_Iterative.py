# Created by Aashish Adhikari at 1:24 PM 3/26/2021

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


'''
Time Complexity:
O(k)
Space Complexity:
O(logn) where n is the height of the tree and logn is the height of the tree
'''

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """


        recursive_stack = []
        node = root
        total_elems = 0

        while node is not None or len(recursive_stack) != 0:

            # traverse the left side
            while node is not None:
                recursive_stack.append(node) # put the parent in the recursive stack
                node = node.left             # now go to the left child


            # the parent
            node = recursive_stack.pop()
            total_elems += 1

            if total_elems == k:
                return node.val


            # traverse right
            node = node.right





        