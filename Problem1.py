'''
Problem:  Kth Smallest Element in a BST
Time Complexity: O(n), where n is nodes in tree
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        get inorder traversel till k nodes
        return the kth element
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        inorder = []
        self.count = 0
        def helper(root):
            if root is None or self.count == k:
                return
            
            if self.count!=k:
                helper(root.left)
            
            inorder.append(root.val)
            self.count+=1

            if self.count!=k:
                helper(root.right)
        
        helper(root)
        print(inorder)
        return inorder[k-1]