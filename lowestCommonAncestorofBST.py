#TimeComplexity:O(Depth) 
#SpaceComplexity: O(Depth)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #print(root.val)
        if root.val==p.val or root.val==q.val:#since BST is sorted we check if any of p,q are root then it is answer
            return root
        elif (root.val>=p.val and root.val<=q.val) or (root.val<=p.val and root.val>=q.val):#If one is smaller and other is greater then root is the parent for both since one will be in left subtree and other will be in right subtree.
            return root
        elif root.val<p.val and root.val<q.val:#if both are greater than root repeat same procedure for right subtree
            return self.lowestCommonAncestor(root.right,p,q)
        else:# else repeat for left subtree
            return self.lowestCommonAncestor(root.left,p,q)
        