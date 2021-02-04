/*
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        
        p_path = []
        q_path = []
        self.backtrack(root, p, p_path)
        self.backtrack(root, q, q_path)
        i = 0
        
        i = 0
        while i < min(len(p_path), len(q_path)):
            if p_path[i] != q_path[i]:
                break
            i += 1
        return p_path[i-1]
    
    def backtrack(self, root, p, path):
        if root is None:
            return
        
        path.append(root)
        if root.val == p:
            return
        
        self.backtrack(root.left, p, path)                 
        if path[-1] == p:                        # this condition is little optimization which will ensure if we found p then no need to go ahead see another function for clarification
            return
        
        self.backtrack(root.right, p, path)
        if path[-1] == p:                        # this condition is little optimization which will ensure if we found p then no need to go ahead 
            return
        path.pop()
    
    """                             
    def backtrack(self, root, p, path):     # this will run for that nodes of tree which are not required so above one is little optimized
        if root is None:
            return
        
        path.append(root)
        if root == p:
            return
        
        self.backtrack(root.left, p, path)
        
        
        self.backtrack(root.right, p, path)
        if path[-1] != p:
            path.pop()
    
    """
    
*/

/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        
        List<TreeNode> p_path = new ArrayList<>();
        List<TreeNode> q_path = new ArrayList<>();
        backtrack(root, p, p_path);
        backtrack(root, q, q_path);
        int i=0;
        for (;i<Math.min(p_path.size(), q_path.size()); i++){
            if (p_path.get(i) != q_path.get(i))
                break;
        }
        return p_path.get(i-1);
    }
    private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path){
        if (root == null)
            return;
        
        path.add(root);
        if (root == p)
            return;
        
        backtrack(root.left, p, path);
        if (path.get(path.size()-1) == p)
            return;
        
        backtrack(root.right, p, path);
        if (path.get(path.size()-1) == p)
            return;
        
        path.remove(path.size()-1);
        
    }
}
*/

/*
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left is not None and right is not None:
            return root
        
        elif right is not None:
            return right
        
        elif left is not None:
            return left
        
        else:
            return None
*/

// Time - O(h) where h is height
// Space - O(h)
// Logic - we will have four condition either root it equal is one of the elements or they both are in left subtree or right subtree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null)
            return root;
        
        else if (left != null)
            return left;
        
        else if (right != null)
            return right;
        
        else
            return null;
    }
    
}