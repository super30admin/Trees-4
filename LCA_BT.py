class BinaryTree:

    def lowestCommonAncestor(self, root, p, q):

        if (root == p or root == q or root == None):
            return root

        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)


        if left and right:
            return root

        elif left:
            return left

        else:
            return right


result = BinaryTree()
output = result.lowestCommonAncestor(root, p, q) #Where root is a binary tree

