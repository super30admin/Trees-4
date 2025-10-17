# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # tc : O(n) worst case we migt needto visit each of the node 
    # sc : O(h) recrussive stack 
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # lets recrussively in dfs way search for p and q in the left and right subtree of the root
        # if we found p or q i left subtree lets mark that node as left, same in rigth mark that as right
        # at any point if our left and rigth is not none then we are standign at lca , we will keep returning the root 
        
        if root is None or root == p or root ==q :
            return root 
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        if left == None and right == None:
            return None
        elif left != None and right == None:
            return left
        elif left == None and right != None:
            return right
        else : # if both are not none
            return root
        