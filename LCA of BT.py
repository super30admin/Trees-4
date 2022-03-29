# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    
    def __init__(self):
        # to store LCA node
        self.ans = None
        
    def lowestCommonAncestor(self, root, p,q ):
        
        def recurse(cur):
            if not cur:
                return False
            
            left = recurse(cur.left)
            
            right = recurse(cur.right)
            
            # if cur is p or q
            mid = cur == p or cur == q
            
            # if two or more flags are true
            if mid + left + right >= 2:
                self.ans = cur
                
            return mid or left or right
        
        recurse(root)
        return self.ans