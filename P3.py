# Time: O(N)
# Space: O(k)
# Approach:
Here, at every point we keep a track if we found a value that is either p or q. We are continously traversing 
on left and right and checking for values. Whenever, we find both, we return.


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        # Base case
        if root == None or root == p or root == q:
            return root
        
        
        # Logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # processing flags
        if left != None and right != None:
            return root
        elif left != None:
            return left
        elif right != None:
            return right
        else:
            return None
            return right
