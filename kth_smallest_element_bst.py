# Brute Force Approach: Perform inorder traversal and return element at k- 1 index as value
# Time - O(N) traversal on all roots
# Space - O(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
    
        inOrderTrav = self.inOrder(root)
        #print(inOrderTrav)
        return inOrderTrav[k-1]
        
        
    def inOrder(self, root):
        
        if root == None:
            return []
        
        return self.inOrder(root.left) + [root.val] + self.inOrder(root.right)
        

## Approach 2: Iterative DFS and stop when k becomes zero
# Time - O(N)
# Space - O(H)      


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if root == None:
            return 0
        
        stack = []
        
        while stack != [] or root != None:
            
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            k -= 1
            
            if not k:
                return root.val
            
            root = root.right
                
            
         
# Approach 3: DFS Recursive solution with optimization to suppress recursion(ie stop once we find the kth value)
# Time - O(N)
# Space - O(H) height of Tree is the number of nodes in the stack

def kthSmallest(self, root: TreeNode, k: int) -> int:
        
    self.k = k
    self.result = None
    self.kthSmallestHelper(root, k)
    
    return self.result
     
def kthSmallestHelper(self, root, k):
    # base case
    if root == None:
        return
    
    #logic
    self.kthSmallestHelper(root.left, k)
    
    self.k -= 1
    
    if self.k == 0:
        self.result = root.val
        return
    
    if self.result == None: # if we still havent found the result only then proceed to right side of tree
        self.kthSmallestHelper(root.right, k)       