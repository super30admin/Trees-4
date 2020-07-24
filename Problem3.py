# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 
    
    def __repr__(self):
        return '%d' % (self.val)

class Solution:
    # Method 1) Backtracking approach
    # Time = O(2^n) | Space = O(h)
    # def lowestCommonAncestor(self, root, p, q):
    #     listp = []
    #     listq = []
    #     self.backtrack(root, p, listp) 
    #     self.backtrack(root, q, listq)
    #     print(listp)
    #     print(listq)
    #     for i in range(max(len(listp), len(listq))):
    #         if i >= min(len(listp), len(listq)) or listp[i].val != listq[i].val:
    #             return listp[i-1].val
        
    #     return None 
    
    # def backtrack(self, root, p , arr):
    #     # base 
    #     if not root or root == None:
    #         return 
    #     if root.val == p.val:
    #         arr.append(root)
    #         return 
        
    #     # logic 
    #     # action 
    #     arr.append(root)
    #     # recurse 
    #     self.backtrack(root.left, p ,arr)
    #     if arr[-1].val == p.val:
    #         return 
    #     self.backtrack(root.right, p, arr)
    #     if arr[-1].val == p.val:
    #         return arr 
    #     # backtrack 
    #     arr.pop()
    #     return 
    
    # Method 2) recursive approach 
    # Time = O(n) | space = O(n) for recursive
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base 
        if not root or root == None:
            return root 
        if root.val == p.val:
            return root 
        if root.val == q.val:
            print('Yes')
            return root 
        # logic 
        left = self.lowestCommonAncestor(root.left, p , q)
        right = self.lowestCommonAncestor(root.right, p , q)
        if left is not None and right is not None:
            return root 
        elif left is not None:
            return left 
        elif right is not None:
            return right 
        else:
            return None 

if __name__ == "__main__":
    s = Solution()
    n = Node(3)
    n.left = Node(5)
    n.left.left = Node(6)
    n.left.right = Node(2)
    n.left.right.left = Node(7)
    n.left.right.right = Node(4)
    n.right = Node(1)
    n.right.left = Node(0)
    n.right.right = Node(8)
    
    # Test Case 1 
    p = Node(5)
    q = Node(4)
    res = s.lowestCommonAncestor(n, p , q )
    print(res)