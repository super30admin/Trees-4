# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        stack = []
        while(root != None or stack):
            while(root != None):
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            k-=1
            if(k == 0):
                return root.val
            
            root = root.right

        return -1
