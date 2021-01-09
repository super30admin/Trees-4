// Recursive
// Time - O(N)
// Space - O(N)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null || root == p || root == q) {
             return root;
         }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        else if(left != null) {
            return left;
        }
        else if(right != null) {
            return right;
        }
        else {
            return null;
        }
    }
}

// Time - O(N)
// Space - O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return root;
        }
        
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        
        backtrack(root, p, path1);
        backtrack(root, q, path2);
        int i=0;
        for(; i < Math.min(path1.size(), path2.size()); i++ ){
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        return path1.get(i - 1);
        
    }
    
    private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path) {
        
        if(root == null) {
            return;
        }
        
        path.add(root);
        if(root == p) {
            return;
        }
        backtrack(root.left, p, path);
        if(path.get(path.size() - 1) == p) {
            return;
        }
        backtrack(root.right, p, path);        
        if(path.get(path.size() - 1) == p) {
            return;
        }
        path.remove(path.size() - 1);
    }
}
