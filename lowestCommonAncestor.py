#time complexity: O(n)
#space complexity: O(n)
#if root is not None, p or q recurse for left and right
#if left and right is None return None
# else any of children return a value other than None return the child
# if both children return Non null value return root

def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
      
        if root == None or root == p or root == q:
            return root
            
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left == None and right == None:
            return None
        elif left == None and right!= None:
            return right
        elif left!= None and right == None:
            return left
        else:
            return root
           