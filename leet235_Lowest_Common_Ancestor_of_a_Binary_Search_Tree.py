# Solution

# // Time Complexity : O(log(h)) h is the height of the tree
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Since this is a BST, if both p and q are greater than root then the common ancestor will be on the right side of the tree
# if both p and q are lesser than root then the common ancestor will be on the left side of the tree, if each one of them are
# on the either side of the root, that means root is the least common ancestor. If either p or q is the root then whichever is
# the root is the least common ancestor

# This does not run since I have not worked on creating the BST part instead just wrote the solution

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def lowestCommonAncestor(root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    while root:
        if p.val>root.val and q.val>root.val:
            root = root.right
        elif p.val<root.val and q.val<root.val:
            root = root.left
        elif (p.val == root.val) or (q.val == root.val) or (p.val<root.val and q.val>root.val) or (p.val>root.val and q.val<root.val):
            return root