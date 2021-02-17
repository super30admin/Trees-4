#Time Complexity :O(n)
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #base
        if(root==None or root==p or root==q):
            return root
        
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        
        if(left!=None and right!=None):
            return root
        elif(left!=None):
            return left
        elif(right!=None):
            return right
        else:
            return None