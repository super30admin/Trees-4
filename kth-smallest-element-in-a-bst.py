'''
TC: O(n)
SC: O(H)
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int)
        :rtype: int
        """
                
        def iot(node, arr):
            if not node:
                return 
            iot(node.left, arr)
            arr.append(node.val)
            iot(node.right, arr)
        
        arr = list()
        iot(root, arr)
        
        return arr[k - 1]
        
        