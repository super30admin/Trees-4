## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Time Complexity: O(H + k), where H is the tree height. 
        # We traverse down to the leftmost leaf taking O(H) time, 
        # and then process k nodes. Because of the early exit condition, 
        # we don't traverse the entire tree (unless k = N).
        # Worst case: O(N) if the tree is completely unbalanced (skewed).
        
        # Space Complexity: O(H) to maintain the recursive call stack.
        # Best/Average case (balanced tree): O(\log N)
        # Worst case (skewed tree): O(N)
        
        res = -1
        
        def inorder(node):
            nonlocal k, res
            
            # Base case & Early exit: 
            # If the node is null, or we've already found the answer (k <= 0), stop.
            if not node or k <= 0:
                return
            
            # 1. Traverse the left subtree 
            # (In a BST, the leftmost nodes are the smallest)
            inorder(node.left)
            
            # 2. Process the current node
            k -= 1          # Decrement k since we are visiting a node in ascending order
            if k == 0:      # We have found the k-th smallest element
                res = node.val
                
            # 3. Traverse the right subtree
            # (We only get here if k > 0, meaning we haven't found the answer yet)
            inorder(node.right)
            
        inorder(root)
        return res