#Time Complexity: O(n), where n is the number of nodes in the tree, as the algorithm may traverse all nodes in the worst case.
#Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack.
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if(root==None or root==p or root==q):
            return root
        l = self.lowestCommonAncestor(root.left,p,q)
        r = self.lowestCommonAncestor(root.right,p,q)
        if(l!=None and r!=None):
            return root
        elif(l!=None):
            return l
        else:
            return r