# Time Complexity :
# O(N) - Number of elements

# Space Complexity :
# O(H) - height of the tree

# Did this code successfully run on Leetcode :
#Yes

#We do a DFS traversal of the tree along with backtracking.
#At each step, we add the root node to the path, check if the current root is one of the elements, if it is,we store the current path.
#Else continue the DFS 
#At the end of the DFS we remove the root we just added
#At the end of the DFS, we have the paths to both elements, then we go throug hthe paths until they are same and return the last common element

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.p_path = []
        self.q_path = []
        self.dfs(root,[],p,q)
        common_anscestor = root
        for i in range(1,min(len(self.p_path),len(self.q_path))):
            if self.p_path[i].val == self.q_path[i].val :
                common_anscestor = self.q_path[i]
        return common_anscestor

    def dfs(self,root,path,p,q):
        if root == None :
            return
        path.append(root)
        if root.val == p.val :
            self.p_path = path[:]
        if root.val == q.val :
            self.q_path = path[:]

        if len(self.p_path) != 0 and len(self.q_path) != 0 :
            return
        self.dfs(root.left, path,p,q)
        self.dfs(root.right, path,p,q)
        path.pop(-1)
