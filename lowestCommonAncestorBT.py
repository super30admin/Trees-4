# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted on leetcode
#Time complexity - O(N) as we traverse every node
#Space omplexity - O(1)

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #Base case
        if root == None or root == p or root == q:
            return root
        #Logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        #Case1
        if left != None and right != None:
            return root
        #Case2:
        elif left != None:
            return left
        #Case3:
        elif right != None:
            return right
        #Case4:
        else:
            return None