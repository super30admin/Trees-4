"""Time Complexity : O(n)
 Space Complexity : O(n) 
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : yes, initially i just returned the root, but due to this the main return was of a null value


 Your code here along with comments explaining your approach """


class Solution:
     
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return
        elif root.val == p.val or root.val == q.val:
            return root
        p1 = self.lowestCommonAncestor(root.left, p, q)
        q1 = self.lowestCommonAncestor(root.right, p, q)
        
        if p1 != None and q1 != None:
            return root
        elif p1!= None and q1 == None:
            return p1
        elif p1 == None and q1!= None:
            return q1
        else:
            return 
            
        