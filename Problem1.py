# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    """

        Name : Shahreen Shahjahan Psyche
        Time : O(N) [Where N repreesents the number of Nodes]
        Space: Recursive Solution : O(H) [Recursive Stack Space]
               Iterative Solution : O(H) [Auxiliary External Stack]
        
        Passed Test Cases in LC : Yes


    """
    
    
    # Doing InOrder Traversal to get to the smallest node of the BST and then whilee popping each node - tracking the count. 
    # when it is equal to k or k goes down to 0, returning the node's valuee
    
    def __init__(self):
        self.result = float('inf') 
        self.count = 0
    
    def iterative(self, root, k):
        track = []
        track.append(root)
        while(root is not None or track):
            while root:
                track.append(root)
                root = root.left 
            root = track.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        
        return float('inf')
                
        
    def recursive(self, root, k):
        # base case
        if root is None:
            return
        self.recursive(root.left, k)
        self.count += 1
        if k == self.count:
            self.result = root.val 
        self.recursive(root.right, k)
        
    
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if not root:
            return float('inf')
        
        self.recursive(root, k)
        return self.result
        
