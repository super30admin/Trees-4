## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Solution 1: Recursive Approach
        
        Logic: 
        Leverages the Binary Search Tree (BST) property. If both p and q are greater 
        than the current root, the LCA must be in the right subtree. If both are lesser, 
        the LCA must be in the left subtree. If one is greater and one is lesser (or one 
        equals the root), we have found the split point, making the current root the LCA.
        
        Time Complexity: O(H) where H is the height of the tree. In the worst-case 
                         (a skewed tree), this is O(N). For a balanced tree, it is O(log N).
        Space Complexity: O(H) due to the recursive call stack. Worst-case O(N), 
                          O(log N) for a balanced tree.
        
        Note: This is the less efficient solution due to the space required for the 
              call stack, so it is kept commented out.
        """
        # if root.val > p.val and root.val > q.val:
        #     return self.lowestCommonAncestor(root.left, p, q)
        # elif root.val < p.val and root.val < q.val:
        #     return self.lowestCommonAncestor(root.right, p, q)
        # else:
        #     return root


        """
        Solution 2: Iterative Approach
        
        Logic: 
        Uses the same BST property as the recursive solution but applies a while loop 
        to traverse down the tree. It simply updates the root pointer to the left or 
        right child based on the values until the split point is found, avoiding the 
        overhead of recursive calls.
               
        Time Complexity: O(H) where H is the height of the tree. Worst-case O(N) 
                         for a skewed tree, O(log N) for a balanced tree.
        Space Complexity: O(1) since it only uses a few pointers and no call stack 
                          is generated.
        """
        while True:
            if p.val > root.val and q.val > root.val:
                root = root.right
            elif p.val < root.val and q.val < root.val:
                root = root.left
            else:
                return root