'''
Did it run on leetcode: Yes
Did you face any problem: No

Time Complexity: 0(N)
Space Complexity: 0(H) recursive stack

Algorithm:
- Do a inorder traversal of the tree
- check if the one of the values is greater than root and other is smaller, then you have the 
LCA.
- if its not then you can go either left or either right based on the values.

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
        
        while(True):
            if(root and root.val>p.val and root.val>q.val):
                root =root.left
                continue
            elif(root and root.val<p.val and root.val<q.val):
                root=root.right
                continue
            break
        return root