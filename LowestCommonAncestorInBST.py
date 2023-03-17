# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#All TC passed on leetcode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':


        #Here we perform dfs, we move to left or right based on p and q's values. If they are less than root then we move to left, if they are greater than root then we move to right. If one is lesser and another is greater than root then we return root.
        #Iterative approach using stack for dfs
        #Time complexity: O(n) - where n is all nodes of tree
        #Space complexity - O(h) - h is height of tree, stack size is max height of tree
        stack = []
        stack.append(root)
        while stack:
            n = stack.pop()
            if p.val<n.val and q.val<n.val:
                if n.left:
                    stack.append(n.left)
            elif p.val>n.val and q.val>n.val:
                if n.right:
                    stack.append(n.right)
            else:
                return n

#-------------------------------------------OR--------------------------------------------
        
        #Iterative approach
        #Time complexity: O(n) - where n is all nodes of tree
        #Space complexity - O(1)
        while(True):
            if p.val<root.val and q.val<root.val:
                root = root.left
            elif p.val>root.val and q.val>root.val:
                root = root.right
            else:
                return root

#-------------------------------------------OR--------------------------------------------
        
        #Recurssive approach
        #Time complexity: O(n) - where n is all nodes of tree
        #Space complexity - O(h) - h is height of tree, recurssion stack space is max height of tree
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root


        