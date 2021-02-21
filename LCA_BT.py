# TC: O(n)
# SC: O(n)
# We use two path arrays to record paths of p and q. When we encounter p or q- we record node twice in the respective paths(just for convinience of comparing 2 arrays).  
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or not p or not q: return None
        path1, path2 = [], []
        self.helper(root, p, path1)
        self.helper(root, q, path2)
        
        for i in range(len(path1)):
            if path1[i] != path2[i]:
                return path1[i-1]
        return None
    
    def helper(self, root, p, path):
        # base
        if root == None: return
        if root == p: 
            path.append(root)
            path.append(root)
            return
        # logic
        # action
        path.append(root)
        # recurse
        self.helper(root.left, p, path)
        # if path[len(path)-1] == p: return
        self.helper(root.right, p, path)
        if path[len(path)-1] == p: return
        # backtrack
        path.pop()

# TC: O(n)
# SC: O(n)
# We use flags to register presence of node in the subtree. At node level- if both recursions return values- that is the LCA which we return to the parent until exited from recursion
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base
        if root == p or root == q or root == None:
            return root
        # logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right,p, q)
        
        if left != None and right != None: return root
        elif left != None: return left
        elif right != None: return right
        else: return None