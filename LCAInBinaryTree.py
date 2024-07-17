# Time Complexity:
# O(n)

# Space Complexity:  
# O(h)

# Approach: 
# Bottom-up Recursion


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.pathP = []     # List of TreeNode's
        self.pathQ = []     # List of TreeNode's
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # Approach 2: Bottom-Up recursion ===> TC = O(n) , SC = O(h) 
        if not root or root==p or root==q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if not left and not right:
            return None

        elif not left and right:
            return right
        elif not right and left:
            return left
        
        else:
            return root