# Approach:
# The problem requires finding the kth smallest element in a BST, which can be solved efficiently using an in-order traversal.
# In-order traversal of a BST gives the nodes in ascending order.
# By keeping a counter, we can stop the traversal as soon as we reach the kth element.

# Time Complexity: O(H + k), where H is the height of the tree. In the worst case, it could be O(n).
# Space Complexity: O(H), for the recursion stack during in-order traversal.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Initialize variables for in-order traversal
        self.k = k
        self.result = None

        def in_order_traversal(node):
            # Base case: if node is None, return
            if not node:
                return
            
            # Traverse the left subtree
            in_order_traversal(node.left)
            
            # Decrement k and check if it's the kth element
            self.k -= 1
            if self.k == 0:
                self.result = node.val
                return
            
            # Traverse the right subtree
            in_order_traversal(node.right)

        # Perform the in-order traversal starting from the root
        in_order_traversal(root)
        
        # Return the kth smallest element found
        return self.result
