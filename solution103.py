# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#backtracking approach
#Time Complexity:O(H)
#Space Complexity:O(m+n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path1=[]                                                    #create two paths path 1 and path2 call backtrack function for path1 to search p and path2 to search q
        path2=[]
        self.backtrack(root,p,path1)
        self.backtrack(root,q,path2)
        for i in range(len(path1)):                                 #compare path1 and path2 elemnts. when non matching elements are found return previously matched element
            if path1[i]!=path2[i]:
                return path1[i-1]
        return None
    
    def backtrack(self,root:'TreeNode',p:'TreeNode',path:List['TreeNode']):
        if not root:
            return
        if root==p:                                                 #if root value is same as p append the root to path
            path.append(root)
        path.append(root)                                           #append root to path
        self.backtrack(root.left,p,path)                            #call backtrack on left and right subtrees to find p
        if path[-1]==p:                                             #if the last element in path is p then return
            return
        self.backtrack(root.right,p,path)
        if path[-1]==p:
            return
        path.pop()                                                  #remove the last element from path

#Recursive approach
#Time Complexity:O(H)
#Space Complexity:O(H)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root==p or root==q:                              #if a null value or p or q is found as root return root
            return root
        left=self.lowestCommonAncestor(root.left,p,q)                   #call recursive function for left subtree
        right=self.lowestCommonAncestor(root.right,p,q)                 #call recursive function for right subtree
        
        if left and right:                                              #if both left and right subtree exist return root
            return root
        elif left:                                                      #if only left exists return left and same for right else return None
            return left
        elif right:
            return right
        else:
            return None