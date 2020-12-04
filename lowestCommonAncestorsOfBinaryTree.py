#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(n) where n is number of nodes in the tree
#Did this code successfully run on Leetcode : Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    class node:
        def __init__(self, val, node):
            self.val = val
            self.node = node

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root, p, q):
            #if we reach a Null node
            if not root:
                return self.node(0, None)

            leftnode = helper(root.left, p, q)
            #check if we've found both nodes on the left of root
            if leftnode.val == 2:
                return leftnode
            rightnode = helper(root.right, p, q)
            #check if we've found both nodes on the right of root
            if rightnode.val == 2:
                return rightnode

            #calculate how many nodes we've found from both left and right
            total = leftnode.val + rightnode.val + (1 if root==p else 0) + (1 if root==q else 0)

            #see if we've found both nodes 
            if total == 2:
                return self.node(total, root)

            return self.node(total, None)

        return helper(root, p, q).node
