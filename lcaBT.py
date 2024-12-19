# // Time Complexity :O(n) tree Traversal for last element
# // Space Complexity :O(h) recrsion stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No 


# // Your code here along with comments explaining your approach

# Backtracking iterative using path T: O(n) ; S: O(n + p + q) path, p and q
class Solution:

    def __init__(self):
        self.pathP = []                         # defined ds
        self.pathQ = [] 
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        self.helper(root,p,q,[])

        for i in range(min(len(self.pathP), len(self.pathQ))):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]
        return None

    def helper(self,root,p,q,path): 
        #basecase
        if not root: return 

        #logic
        path.append(root)                       # action -> deepcopy root in path

        if root == p:
            self.pathP = path[:]
            self.pathP.append(root)

        if root == q:
            self.pathQ = path[:]
            self.pathQ.append(root)

        self.helper(root.left,p,q,path)         # recursion
        self.helper(root.right,p,q,path)

        path.pop()                              # backtrack


# Recursive  T: O(n) ; S: O(h) recursion stack
class Solution3:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def helper(root):
            #basecase
            if root == None or root == p or root == q:          # empty root or reach target.
                return root
            #logic 
            if root:                                            # early exit
                left = helper(root.left)
            if root:
                right = helper(root.right)

            if left and right: return root
            elif not left: return right
            else: return left

            
        return helper(root)
    

# Recursive 2 (same as above)
class Solution2:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def helper(root):
            #basecase
            if root == None or root == p or root == q:
                return root
            #logic 

            left = helper(root.left)
            right = helper(root.right)

            if not left and not right: return None
            elif not left and right : return right
            elif left and not right : return left
            else: return root

            
        return helper(root)