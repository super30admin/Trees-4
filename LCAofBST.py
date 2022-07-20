# Iterative Solution:
# TC: O(N) - at max we will have to traverse entire tree to find both the elements
# SC: O(1) we are not using any extra space
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        cur = root
        
        while cur:
            # if p and q are both bigger than cur, we check right subtree
            if p.val > cur.val and q.val > cur.val :
                cur = cur.right
            elif p.val < cur.val and q.val < cur.val : # else check left subtree
                cur = cur.left
            else: # if neither of above is true then cur node is where split happened, p and q are on two sides of cur node, that is our LCA
                return cur


# Recursive approach:
# TC: O(N) - at max we will have to traverse entire tree to find both the elements
# SC: O(N) - Extra space for stack
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root