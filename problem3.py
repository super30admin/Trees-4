#time complexity: O(n)
#space complexity: O(max. depth)
#ran on leetcode: Yes
#Do a post order traversal of the binary tree. if both the left and right subtree traversals give a value that is not null, this means that both the nodes have been found in either side, root will be LCA in this case and so return root in this case. If root is p or q, return root since this is one of those 2 nodes. Else return the result from left subtree or right subtree.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rec(self,root,p,q):
        if(root==None):
            return None

        node1=self.rec(root.left,p,q)
        node2=self.rec(root.right,p,q)
        if(node1 and node2):
            return root
        
        elif(root==p or root==q):
            return root
        else:
            return node1 or node2      
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.rec(root,p,q)
