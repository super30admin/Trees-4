#time complexity: O(n)
#space complexity: O(max.depth)
#ran on leetcode: Yes
#do a BST traversal. if both p and q are situated on either side of root, then root is LCA. Else, recurse to the left part or right part depending on the values of p, q and root.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def traversal(self,root,p,q):
        if(root==None):
            return None
        
        if(root.val==p.val or root.val==q.val):
            return root
        else:
            if(root.val>p.val and root.val>q.val):
                return self.traversal(root.left,p,q)
            elif(root.val<p.val and root.val<q.val):
                return self.traversal(root.right,p,q)
            else:
                 #ans1=self.traversal(root.left,p,q) 
                 #ans2= self.traversal(root.right,p,q)
                 return root

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.traversal(root,p,q)
