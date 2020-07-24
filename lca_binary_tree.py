#RECURSIVE SOLUTION (post-order pattern)
#Time complexity: O(n)
#Space complexity: O(h)
'''
Propagate from bottom if left is found and right is found (p,q).
We have to traverse post-orderly to make sure we don't miss anything.
This works because if they are not found in the left and right subtree
respectively, it means the common ancestor not this one and is in
one of the subtree. Also, only one of them will have true for left
and right. left could be p and q , we don't know. 
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        found=None
        def helper(root,p,q):
            nonlocal found
            if not root or found:
                return False
            
            left=helper(root.left,p,q)
            right=helper(root.right,p,q)
            
            #either left and right or left and present root,right and present root
            mid= (root==p or root==q)
            if left+right+mid>=2:
                found=root
            return (mid or right or left)
            
        helper(root,p,q)
        return found
        
        
        
#ALTERNATIVE SOLUTION (recursive)
'''
When p or q it's found, the root that contains it is propagated
to the top until one root has left and right, then this one
is propagated to the top. On the top level, we
return whatever was propagted to there. If the top level is
the common ancestor, then left and right were propagated to there.
If not, then only one side has propagated something and it's the
common ancestor. Only one node will have both left and right (above that,
they would be in the same subtree).

'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root==p or root==q: return root
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        if left and right: return root
        if left: return left
        if right: return right        
 
