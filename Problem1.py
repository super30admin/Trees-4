# // Time Complexity : O(n) where n is the number of nodes.
# // Space Complexity : O(n) where n is the number of nodes.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.nodes = []
        def inorder(root):
            # base
            if root == None:
                return
            # logic
            inorder(root.left)
            self.nodes.append(root.val)
            inorder(root.right)
        inorder(root)
        print(self.nodes)
        return self.nodes[k-1]
