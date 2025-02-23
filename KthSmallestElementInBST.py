# Time Complexity : O(n) - inorder traversal
# Space Complexity : O(h), recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# doing inorder traversal, and keeping count of the no of elements iterated using count
# decrementing count at every pop operation
# when count == 0, we have gone over k elements
# so we are now at the kth smallest element
# smallest because using inorder on BST - sorted order


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.cnt = 0
        self.ans = -1

    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        if root is None:
            return -1
        
        self.cnt = k
        # inorder traversal
        self.inorder(root)
        return self.ans
    
    def inorder(self, root):
        # base case
        if root is None:
            return

        # logic
        # left recursive call
        self.inorder(root.left)
        # at every pop we reduce count
        self.cnt -= 1

        # if count is decremented k times, count will become 0
        if self.cnt == 0:
            self.ans = root.val
            return
        self.inorder(root.right)
        




        