#Lowest Common Ancestor of a Binary Search Tree
# // Time Complexity :  O(H)- height of tree
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def lowestCommonAncestor(root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    while True:
        if (p.val<root.val and q.val<root.val):         #if both values are smaller than root, we know the ancestor has to be on the left hand side
            root=root.left
        elif (p.val>root.val and q.val>root.val):       #if both values are bigger than root, we know the ancestor has to be on the right hand side
            root=root.right
        else:                                           #else, the root is the ancestor
            return root