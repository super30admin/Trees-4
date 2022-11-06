# Time Complexity: O(h+k)
# Space Complexity: O(h) where h is the height of the tree, worse case - O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


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
        :type k: int
        :rtype: int
        """
        if not root:
            return 
        
        def inorder(node):
            if not node:
                return 
            
            if self.result == -1:
                inorder(node.left)
                
            self.count+=1
            if self.count == k:
                self.result = node.val
                return
            
            if self.result == -1:
                inorder(node.right)
        
        self.count = 0
        self.result = -1
        inorder(root)
        return self.result                