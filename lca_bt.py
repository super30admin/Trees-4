"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if not root: return None
        self.path1 = None
        self.path2 = None
        self.helper(root, p, [])
        self.helper(root, q, [])
        size = min(len(self.path1), len(self.path2))
        
        for i in range(size):
            if self.path1[i].val == self.path2[i].val: continue
            else: return self.path1[i-1]
        
        return self.path1[size-1]
        
    def helper(self, root, tn, path):
        # Base case
        if root == None: return
        if root == tn:
            path.append(root)
            if self.path1 == None:
                self.path1 = copy.deepcopy(path)
            else:
                self.path2 = copy.deepcopy(path)                
            return
        
        # Logic
        path.append(root)
        self.helper(root.left, tn, path)
        self.helper(root.right, tn, path)
        path.pop()