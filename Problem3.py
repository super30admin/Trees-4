# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def findEither(root, p, q):
            if not root or root == p or root == q:
                return root
            l = findEither(root.left, p, q)
            r = findEither(root.right, p, q)
            if not l and not r:
                return None
            if l and not r:
                return l
            if r and not l:
                return r
            return root


        return findEither(root, p, q)
