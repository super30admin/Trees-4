# // Time Complexity : O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class solution:
    def lca_recursive(self, root, p, q):
        
        result = self.helper(root,p,q)
        return result
    
    def helper(self, root, p, q):

        ## base
        '''
        we check if our root == None , this is our base case
        '''
        if root == None:
            return 

        ##logic
        '''
        we check the root node if the values are at either side of our roor. if yes then we return our result
        '''
        if (p.val < root.val and q.val >root.val) or (p.val >root.val and q.val<root.val):
            return root
        
        '''
        Else we travel both left and right
        '''
        self.helper(root.left)
        self.helper(root.right)
    

    def lca_iterative(self, root,p,q):

        curr = root
        '''
        we iterate until root is None

        if both values are less than root then we move towards left

        if both values are greater than root then we move towards right

        if both are onn opposite side then return root
        '''
        while curr:

            if p.val < curr.val and q.val <curr.val:
                curr = curr.left
            elif p.val >curr.val and q.val > curr.val:
                curr = curr.right
            
            else:
                return curr
