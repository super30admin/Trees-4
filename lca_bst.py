#RECURSIVE SOLUTION
#Time Complexity: O(n) (Olog(n)) if balanced
#Space complexity: O(n) for call stack (logn if balanced)
'''
as soon as they split (or equal to) we return the node, because it is lowest common ancestor (first time)
we allow equal to take care of the case where p is a descendent of q
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        found=None
        def helper(root,p,q):
            nonlocal found
            if not root or found:
                return
            if (p.val>=root.val and q.val<=root.val) or (q.val>=root.val and p.val<=root.val):
                found=root
            helper(root.left,p,q)
            helper(root.right,p,q)
        helper(root,p,q)
        return found
        
        
#ITERATIVE SOLUTION (pre-order traversal pattern)
#Time Complexity: O(n) (Olog(n)) if balanced
#Space complexity: O(n) for call stack (logn if balanced)

'''
as soon as they split (or equal to) we return the node, because it is lowest common ancestor (first time)
we allow equal to take care of the case where p is a descendent of q
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        st=[root]
        while st:
            root=st.pop()
            if (p.val>=root.val and q.val<=root.val) or (p.val<=root.val and q.val>=root.val):
                return root
            if root.left:
                st.append(root.left)
            if root.right:
                st.append(root.right)
