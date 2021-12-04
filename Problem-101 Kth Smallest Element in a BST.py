# 230. Kth Smallest Element in a BST
# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative Solution:

# Logic: We use the property of inorder traversal that, inorder traversal 
# of tha BST will give us a sorted list. So the kth smallest element will 
# be the kth element in the inorder traversal.

# Time Complexity: O(n)
# Space Complexity: O(n) [it will be O(h) but in the worst case it can be O(n)]
class Solution:
    def kthSmallest(self, root, k: int) -> int:
        stack = []
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            
            k -= 1
            node = stack.pop()
            
            if k == 0:
                return node.val
            
            if node.right:
                root = node.right

# Recursive Solution:

# Logic: We recurse over the BST in inorder traversal. In case of null nodes we 
# return inf and then take min of the outputs from the left and right children. 
# We reduce the value of k to 0 and when k is 0, we return the node we are standing on.

# Time Complexity: O(n)
# Space Complexity: O(n) [it will be O(h) but in the worst case it can be O(n)] [Stack]

class Solution:
    def __init__(self):
        self.x = 0
        
    def _helper(self, node):
        if not node:
            return inf
        
        if node:
            l = self._helper(node.left)
            self.x -= 1
            if self.x == 0:
                return node.val
            r = self._helper(node.right)
        return min(l,r)
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.x = k
        
        return self._helper(root)