#Recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we have to find the least common ancestor for the given two nodes.When we observe if the Given two nodes in BST are on the either side of the root then we return the root.if the two given nodes are on the left side then we traverse to the left side and if they are on the other side of the root then we go towards the right side.

# Recursive solution
# Time complexity --> o(logn)
# space complexity --> o(logn)
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
        
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root

#Iterative solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:

In this problem we have to find the least common ancestor for the given two nodes.When we observe if the Given two nodes in BST are on the either side of the root then we return the root.if the two given nodes are on the left side then we traverse to the left side and if they are on the other side of the root then we go towards the right side.

# Iterative solution
# Time complexity --> o(logn)
# space complexity --> o(1)
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
        while True:
            if p.val<root.val and q.val<root.val:
                root=root.left
            elif p.val>root.val and q.val >root.val:
                root=root.right
            else:
                return root
        