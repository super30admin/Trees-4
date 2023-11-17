# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    count=0

    def inorder(self,root,k):
        if not root:
            return 0
        res=0
        res=self.inorder(root.left,k)
        self.count+=1
        if(self.count==k):
            res=root.val
        if(self.count<k):
            res=self.inorder(root.right, k)
        return res
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        return self.inorder(root,k)
      

        