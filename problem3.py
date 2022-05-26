#Lowest Common Ancestor of a Binary Tree
# // Time Complexity :  O(N)
# // Space Complexity : O(H) - recursive stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def lowestCommonAncestor( root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

    def dfs(root, p, q):    
        if(root==None or root==p or root==q):             #  if either the root is None or p or q, then just return its value
            return root

        left = dfs(root.left, p, q)
        right = dfs(root.right, p, q)

        if right and left:                              #if right and left both exists, then you know the ancestor is the root
            return root
        if right:                                       #if only right exists, then its the right
            return right
        if left:                                        #if only left exists, then its the left
            return left
    return dfs(root, p, q)