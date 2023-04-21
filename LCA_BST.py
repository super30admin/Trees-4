class BST:

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
        


result = BST()
output = result.lowestCommonAncestor(root, 5, 8) #where root is a binary Tree
print(output)