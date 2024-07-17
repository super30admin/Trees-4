# Time Complexity:
# O(h) , h = height of the tree

# Space Complexity:  
# O(1)   

# Approach: 
# Iterative solution, Use pointers to traverse the tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):       
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # Using Iterative approach ===> TC = O(h), SC = O(1) (due to no recusive stack space)
        if not root:
            return
        
        while(True):
            if root.val > p.val and root.val > q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root