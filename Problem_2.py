# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
Time Complexity - O(n)
Space Complexity - O(1) in case of for loop. O(H) recursive stack space for recursive.
Works on Leetcode
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #using while loop
        while root != None:
            if p.val > root.val and q.val > root.val:
                root = root.right #go right if root val is less than the val left and right
            elif p.val < root.val and q.val < root.val:
                root = root.left #go left if root val is greater than the val of left and right
            else:
                return root #return the node whose left is less than root and right child is greater(its the LCA) 
        # return self.findLCA(root, p, q) #DFS Method

    def findLCA(self, root, p, q):
        #base
        if root == None:
            return None

        #logic
        if p.val>root.val and q.val > root.val:
            return self.findLCA(root.right, p, q)
        elif p.val < root.val and q.val < root.val:
            return findLCA(root.left, p, q)
        else:
            return root
        