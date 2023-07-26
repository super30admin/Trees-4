#Time complexity is: O(logn)
#Space complexity is:O(1)
#Code ran successfully on leetcode
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
        #Iterating through while loop where the ondition will be always true
        while(True):
            #If root value is greater than both p and q values, we will move the root to the left 
            if(root.val>p.val and root.val>q.val):
                root=root.left
            #If root value is lesser than both p and q values, we will move the root to the right
            elif(root.val<p.val and root.val<q.val):
                root=root.right
            #If the above conditions donot satisfy, we will return root
            else:
                return root
