# time : 0(logN)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        
        if p.val > root.val and q.val > root.val :
            return self.lowestCommonAncestor(root.right,p,q)
        
        return root