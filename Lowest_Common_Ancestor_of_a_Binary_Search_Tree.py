# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        """
        Time complexity : O(N)
        Space complexity : O(1)
        Lowest Common Ancestor of a Binary Search Tree
        """
        
        node = root
        p_val = p.val
        q_val = q.val
        
        while node:
            if node.val < p_val and node.val < q_val:
                node = node.right
            elif node.val > p_val and node.val > q_val:
                node = node.left
            else:
                return node
        
#         self.final = []
#         def find(root):
#             val1 = False
#             if root.val == p.val:
#                 val1 = True
#             elif root.right and root.val < p.val:
#                 val1 = find(root.right)
#             elif root.left and root.val > p.val:
#                 val1 = find(root.left)
                
#             val2 = False
#             if root.val == q.val:
#                 val2 = True
#             elif root.right and root.val < q.val:
#                 val2 = find(root.right)
#             elif root.left and root.val > q.val:
#                 val2 = find(root.left)
            
#             if val1 and val2:
#                 self.final.append(root)
#                 return True
#             elif val1 or val2:
#                 return True
#             else:
#                 return False
#         find(root)
#         print(self.final)
#         return self.final[0]
        