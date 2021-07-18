 """Time Complexity : O(n)
 Space Complexity : 
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : yes, initially i just returned the root, but due to this the main return was of a null value


 Your code here along with comments explaining your approach """

 class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        print(root.val)
        if p.val > root.val and q.val> root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif q.val < root.val and p.val<root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root
            
        
