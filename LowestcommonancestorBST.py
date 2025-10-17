# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # tc : O(h) for balanced binary tree logn, skwes tree n 
    # sc : O(1) while loop handles the recrussion and no extra space used 
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
       # since its a bst if our pval and q val are less thna root then we search left subtree to find the p,q if they are greater then root then we search the right
       # but if the vals are one is less than root and one if greater then the rot then our root is the lowest common ancestor 
        while True:
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else : # 
                return root

        

