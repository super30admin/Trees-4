#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        
        parent_val = root.val

        p_val = p.val

        q_val = q.val

        if p_val > parent_val and q_val > parent_val:    
            return self.lowestCommonAncestor(root.right, p, q)
  
        elif p_val < parent_val and q_val < parent_val:    
            return self.lowestCommonAncestor(root.left, p, q)

        else:
            return root