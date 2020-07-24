# find the kth smallest element
# using inorder traversal (left root right -- the element on the left is less than the root node.) 
# as soon as you hit the kth element, stop.
# time complexity - O(n)  
# space complexity - O(h)
# did this code successfully run on leetcode? - yes
# any issues faced? - had difficulty understanding how to return the value. was able to find my answer in the lecture video.
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root: return
        result = -1
        
        def rec(node):
            if node:
                rec(node.left)
                nonlocal k
                k-=1
                if k==0:
                    nonlocal result
                    result = node.val
                rec(node.right)
        
        rec(root)
        return result
    
# Inorder traversal
# iterative procedure (using stacks)
# as soon as you hit the kth element, stop.
# time complexity - O(n)  
# space complexity - O(h)
# did this code successfully run on leetcode? - yes
# any issues faced? - No
from collections import deque
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        node_stack = deque()
        
        while root or node_stack:
            while root:
                node_stack.append(root)
                root = root.left
            root = node_stack.pop()
            k-=1
            if k==0:
                return root.val
            root = root.right
        
        return -1