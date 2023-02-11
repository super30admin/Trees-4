# Time Complexity :
# O(H) - height of the tree

# Space Complexity :
# O(H)

# Did this code successfully run on Leetcode :
#Yes

#If both the required values are on the left of the root, then we search for them in the left half of the tree and vice versa on the right
#If one element is on the right and one one left, we are done - the root is the common anscestor.
#We call this function recursively until both the required numbers are on different sides or at the root itself

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > q.val and root.val > p.val :
            return self.lowestCommonAncestor(root.left,p,q)
        elif root.val < q.val and root.val < p.val :
            return self.lowestCommonAncestor(root.right,p,q)
        else :
            return root
