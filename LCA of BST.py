# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def lowestCommonAncestor(self, root, p,q ):
        p_val = p.val
        q_val = q.val
        node = root
        
        while node:
            parent = node.val
            
            # check if p and q are greater than parent, then traverse right
            if p_val > parent and q_val > parent:
                node = node.right
                
            # check if p and q are smaller than parent, then traverse left
            elif p_val < parent and q_val < parent:
                node = node.left
            
            else:
                return node # found the split