#Time complexity is: O(n)
#Space complexity is: O(1)
#code ran successfully on leetcode
#No issues faced while coding

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
        #If the root is equal to None or p or q we will retyrn the root
        if(root==None or root==p or root==q):
            return root
        #We will be going through the left of the tree
        left=self.lowestCommonAncestor(root.left,p,q)
        #We will be going through thr right of the tree
        right=self.lowestCommonAncestor(root.right,p,q)
        #If both left and right are None, we will return None to the root
        if(left==None and right==None):
            return None
        #If only right is None, we will return left value to the root
        elif(left!=None and right==None):
            return left
        #If only left is None, we will only return right value to the root
        elif(left==None and right!=None):
            return right
        #If both left and right have values, we will return root value to the parent
        else:
            return root
        