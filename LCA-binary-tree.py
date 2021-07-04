'''
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
Did it run on leetcode: Yes
Did you face any problem: Yes

Time Complexity: 0(N)
Space Complexity: 0(H) recursive stack

Algorithm:
- Do a post order traversal of the tree
- use bottom up approach when you have results for left and right node.
- And then compare if both left and right are not none then it's the LCA.

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if(root == None):
            return None
        
        if( (root.val==p.val) or (root.val==q.val) ):
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        if(left!=None and right!=None):
            return root
        
        if(left):
            return left
        elif(right):
            return right