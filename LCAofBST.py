# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:    
    # def __init__(self):
    #     self.pList = []
    #     self.qList = []

    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if not root or not p or not q:
    #         return None
        
    #     # Find paths to p and q
    #     self.backtracking(root, [], p.val, True)
    #     self.backtracking(root, [], q.val, False)

    #     # Find the lowest common ancestor by comparing paths
    #     lca = None
    #     for i in range(min(len(self.pList), len(self.qList))):
    #         if self.pList[i] != self.qList[i]:
    #             return lca  # Return the last common node before the paths diverge
    #         lca = self.pList[i]
        
    #     return lca  # If no divergence occurs, return the last common node

    # def backtracking(self, root, path, element, flag):
    #     if not root:
    #         return
        
    #     # Add the current node to the path
    #     path.append(root)
        
    #     # If the target node is found, save the path
    #     if root.val == element:
    #         if flag:
    #             self.pList = path.copy()
    #         else:
    #             self.qList = path.copy()
    #         return

    #     # Recurse into the left or right subtree
    #     if element < root.val:
    #         self.backtracking(root.left, path, element, flag)
    #     else:
    #         self.backtracking(root.right, path, element, flag)

    #     # Backtrack by removing the last node added
    #     path.pop()           



    # Intermediate optimize
    #TC-  O(H)
    #Sc - O(H)
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if not root or not p or not q:
    #         return None
    #     if p.val>root.val and q.val>root.val:
    #         return self.lowestCommonAncestor(root.right,p,q)
    #     elif p.val<root.val and q.val<root.val:
    #         return self.lowestCommonAncestor(root.left,p,q)
    #     else:
    #         return root

    # Optimize on space
    # TC - O(H)
    # SC -O(1)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        while True:
            if p.val>root.val and q.val>root.val:
                root = root.right
            elif q.val<root.val and p.val<root.val:
                root = root.left
            else:
                return root            





 
