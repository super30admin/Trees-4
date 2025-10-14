# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
Solution : DFS 
    - Since, this is BST, we can do conditional recursive calls on left and right subtree
        - only recurse on left if either of 'p' or 'q' is small than current node.
        - only recurse on right if either of 'p' or 'q' is greater than current node
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
        left = None
        if p.val<node.val or q.val<node.val:
            left = self.helper(node.left,p,q)
        
        right = None
        if p.val>node.val or q.val>node.val:
            right = self.helper(node.right,p,q)

        if left == None and right==None: # case1 : both are none
            return None
        elif left!=None and right!=None: # case2 : both are not None. parent is the ancestor
            return node
        elif left!=None: # case3: Only left is Not None
            return left
        else: # case4 : Only right is not None
            return right 

'''
Solution 2: DFS:
    - We recurse on any one side where both targets are present, until we have to
      split.
    - the node at which we need to split, is the LCA. 
Time Complexity: O(h), h = height, complete BST, h= log N 
Space Complexity: O(h), h = height of tree., recursive stack      
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        # Go left, if both targets are present in left sub-tree
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left,p,q)

        # Go right, if both targets are present in right sub-tree
        elif p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        
        # if both targets are not on same side, they are splitting up.
        else:
            return root 


'''
Solution 3: Iterative DFS
    - We recurse on any one side where both targets are present, until we have to
      split.
    - the node at which we need to split, is the LCA. 
Time Complexity: O(h), h = height, complete BST, h= log N 
Space Complexity: O(1),        
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        while True:
            # Go left, if both targets are present in left sub-tree
            if p.val<root.val and q.val<root.val:
                root = root.left

            # Go right, if both targets are present in right sub-tree
            elif p.val>root.val and q.val>root.val:
                root = root.right
            
            # if both targets are not on same side, they are splitting up.
            else:
                return root 
