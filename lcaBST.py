# // Time Complexity :O(h)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
 
# loop T: O(h) ; S: O(1)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        while True:
            if p.val < root.val and  q.val < root.val: 
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root
            

#recursion T: O(h) ; S: O(h)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and  q.val < root.val: 
            return self.lowestCommonAncestor(root.left, p,q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root