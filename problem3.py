# Time Complexity  O(N)
# Space Complexity O(1)

class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        result = self.helper(root, p, q)

        return result

    def helper(self, root, p, q):

        # Base Case
        if (root == None or root == p or root == q): return root

        # Logic
        left = self.helper(root.left, p, q)
        right = self.helper(root.right, p, q)
        if (left == None and right == None): return None
        elif (left != None and right == None): return left
        elif (left == None and right != None): return right
        else: return root    
