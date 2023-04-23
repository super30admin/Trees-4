#Time Complexity : O(N), N being the number of nodes in the tree. 
#Space Complexity : O(h), h being the height of the tree.  
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to look at solution to find the strategy. 
'''Find the path to the two nodes using backtracking. Then, recurse through the two 
paths until the values are not the same. Return the index-1. 
'''
class Solution:
    def __init__(self):
        self.pathp=[]
        self.pathq=[]

    # find the two paths using backtracking. 
    def helper(self, root, p, q, path):
        path.append(root)
        if root==p:
            self.pathp = copy.deepcopy(path)
        if root==q:
            self.pathq = copy.deepcopy(path)
        if root.left:
            self.helper(root.left, p, q, path)
        if root.right:
            self.helper(root.right, p, q, path)
        path.pop(len(path)-1)

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root==None:
            return root
        
        index = 0
        self.helper(root, p, q, [])
        
        #loop through the paths until the values do not equal. 
        length = max(len(self.pathp), len(self.pathq))
        for i in range(length):
            if len(self.pathq)-1<i:
                index = i
                break
            if len(self.pathp)-1<i:
                index = i
                break
            p_node = self.pathp[i]
            q_node = self.pathq[i]
            if p_node.val!=q_node.val:
                index = i
                break

        return self.pathp[index-1]