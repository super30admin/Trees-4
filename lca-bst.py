#lowest common ancestor
# // Time Complexity : O(n) 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
class Solution:
    def lowestCommonAncestor(self, root, p, q):
        while root:
            if root.val>p.val and root.val>q.val:
                root=root.left
            elif root.val< p.val and root.val<q.val:
                root=root.right
            else:
                return root