# T = O(n)
# S =O(h)

# Approach:
# Traverses the tree two times for both the p and q and record the path.
# Once the path is found for both the values iterate both of them until a common values is broken.
# The values previos to the unequal value is the common ancestor

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        path1 ,path2 = [] ,[]
        self.dfs(root,p,path1)
        self.dfs(root,q,path2)
        for i in range(len(path1)):
            if path1[i] != path2[i]:
                return path2[i-1]
        return None
        
        
        
    def dfs(self,Node,target,path):
        ## Logic
        if Node == None :
            return
        
        if Node == target:
            path.append(Node)
        
        ## Recusrsion
        path.append(Node)
        self.dfs(Node.left,target,path)
        if path[-1] == target:
            return

        self.dfs(Node.right,target,path)
        if path[-1] == target:
            return
        path.pop()
        
		
# T = O(n)
# S =O(h)

# Approach:
# Maintain two flags at every node whenever the children are the values p or q return that node to its parent
# Perfom the action recursivley find a node where it has both these flags as some value that is the node.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (not root) or root == p or root == q:
            return root
        
        ## Rcursion:
        
        Left = self.lowestCommonAncestor(root.left,p,q)
        Right = self.lowestCommonAncestor(root.right,p,q)
        
        if Left != None and Right != None:
            return root
        elif Left != None:
            return Left
        elif Right != None:
            return Right
        else:
            return None
        