# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class solution:
    def lca_bt_recursice(self, root, p, q):
        result = self.helper(root, p, q)
        return result
    
    def helper(self, root, p, q):
        '''
        we traverse thorugh our tree in such a way that we will have value of our node in left side and right side of the tree
        and we will recurisvely move towards the left and right. if the node is null or is equal to p or q we return the root

        if both left and right exist that means there is a split and we can return the root.

        if none of the exist then we return none

        if one of them exists we return that because the root itself could be one of the values
        '''
        ## base
        if root == None or p.val == root.val or q.val == root.val:
            return root
        ##logic

        left = self.helper(root.left, p,q)

        right = self.helper(root.right,p,q)

        if left and right:
            return root
        
        if not left and not right:
            return None
        
        return left if left else right