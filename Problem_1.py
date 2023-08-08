"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Kth Smallest Element in a BST

class Solution(object):
    def __init__(self):
        self.count=0
        self.result=None
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.count=k
        self.inorder(root,k)
        return self.result.val

    def inorder(self,root,k):
        if not root:
            return

        if not self.result:
            self.inorder(root.left,k)
        self.count-=1
        if self.count==0:
            self.result=root
            return
        if not self.result:
            self.inorder(root.right,k)