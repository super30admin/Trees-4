"""
Iterative Inorder
TC : O(n)
SC : O(h)
"""
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        count = 0
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            count += 1
            if count == k: return root.val

            root = root.right
        
        return None

"""
Recursive Solution:
TC : O(n)
SC : O(h)
"""
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        result = None
        def inorder(cur):
            if not cur: return
            nonlocal count, result
            if not result: inorder(cur.left)
            count+=1
            if count == k: result = cur.val
            if not result: inorder(cur.right)
        inorder(root)
        return result