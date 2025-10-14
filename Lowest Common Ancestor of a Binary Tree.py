# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

'''
Solution : DFS 
    - at a Node in the tree, when we complete left and right recursive calls, 
      there are 4 cases:
        - left is None && right is None: Meaning we did not find targets in either 
        - left is Not None && right is not None: Meaning, we are standing at LCA
        - left is Not None && right is None: meaning, we found one target in left-subtree
        - left is None && right is Not None: meaning, we found one target in right-subtree
    - At base condition, we check if node==Null, or node==p, or node==q: 
        - Yes, return node
Time Complexity: O(N)
Space Complexity: O(h), h = height of tree.        
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root,p,q) 
    
    def helper(self,node,p,q):
        # base
        if node==None or node==p or node==q:
            return node
        
        # logic
        left = self.helper(node.left,p,q)
        right = self.helper(node.right,p,q)

        if left == None and right==None: # case1 : both are none
            return None
        elif left!=None and right!=None: # case2 : both are not None. parent is the ancestor
            return node
        elif left!=None: # case3: Only left is Not None
            return left
        else: # case4 : Only right is not None
            return right 
