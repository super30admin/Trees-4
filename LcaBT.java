// Time Complexity: O(n)
// Space Complexity: O(n)
// Top-Down
public class LcaBt {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        backtrack(root, p, q , new ArrayList<>());
        
        // check for first mistmatch value and the place of msitmatch will be the answer
        for(int i = 0 ; i < pathP.size(); i++)
        {
            if(pathP.get(i) != pathQ.get(i))
            {
                return pathP.get(i-1);
            }
        }
        return null;
        
    }
    
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        // base
        if(root == null)
            return;
    
        // logic
        // add
        path.add(root);
        if(root == p)
        {
            pathP = new ArrayList<>(path);
            pathP.add(p); // avoid list out of bound and we can return moment elements in path are not equal
        }
        if(root == q)
        {
            pathQ = new ArrayList<>(path);
            pathQ.add(q); // avoid list out of bound and we can return moment elements in path are not equal
        }
    
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        path.remove(path.size()-1);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of tree
// Bottom-Up
public class LcaBt {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null)
            return null;
        if(left == null && right != null)
            return right;
        if(left != null && right == null)
            return left;
        
        // current root is the LCA
        return root;
    }
}

 