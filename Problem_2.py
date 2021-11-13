# Method:
# Return root if both nodes on either side of tree otherwise search in left and right half of BST

# Recursive Solution
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root.val < p.val) and (root.val < q.val):
            return self.lowestCommonAncestor(root.right, p, q)
        elif (root.val > p.val) and (root.val > q.val):
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root 

# Time Complexity: O(log(n)) For balanced BST otherwise O(n)
# Space Complexity: O(log(n)) For balanced BST otherwise O(n)

# Iteartive Solution
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while (1):
            if (root.val < p.val) and (root.val < q.val):
                root = root.right
            elif (root.val > p.val) and (root.val > q.val):
                root = root.left
            else:
                return root 

# Time Complexity: O(log(n)) For balanced BST otherwise O(n)
# Space Complexity: O(1) because no recursive stack used
