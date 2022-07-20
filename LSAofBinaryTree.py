# TC: O(N) as we may need to traverse entire tree to find p and q and then going over lists in a loop may be another O(h)
# SC:O(h) for recursive stack and upto O(2h) forboth paths
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        pPath = []
        qPath= []
        
        def dfs(node, p,q,path):
            #base
            if node is None:
                return 
            path.append(node)
            if node == p:
                pPath.extend(path)
                pPath.append(node)
                
            if node == q:
                qPath.extend(path)
                qPath.append(node)
                
            #logic
            
            dfs(node.left,p,q,path)
            dfs(node.right,p,q,path)

            path.pop()
            
        dfs(root, p, q, [])
       
        for i in range(1,len(pPath)):
            if pPath[i]!=qPath[i]:
                return pPath[i-1]
                
            


# TC: O(N) traversing the entire tree might be necessary
# SC: O(h) height of the tree in recursive stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base
        if root is None or root==p or root == q:
            return root
        #logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        #decide what to return 
        if left == None and right == None:
            return None
        if left!=None and right ==None:
            return left
        if left==None and right!=None:
            return right
        return root  
            
        
        