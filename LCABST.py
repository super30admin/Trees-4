#TC: O(k)
#SC: O(h) in recursion and O(1) in iteration

class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LCA_BST_Recursion:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if (root == None):
            return root
        
        if (p.val < root.val and q.val < root.val):
            return self.lowestCommonAncestor(root.left, p, q)

        elif (p.val > root.val and q.val > root.val):
            return self.lowestCommonAncestor(root.right, p, q)

        else:
            return root


class LCA_BST_Iteration:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if (root == None):
            return root
        
        while (root != None):

            if (p.val < root.val and q.val < root.val):
                root = root.left

            elif (p.val > root.val and q.val > root.val):
                root = root.right

            else:
                return root
        return root