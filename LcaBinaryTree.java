public class LcaBinaryTree {

  /**
   * Time Complexity: O(n)
   * 
   * Space Complexity: O(h)
   *   h - > height of tree
   * 
   * Were you able to solve this on leetcode? Yes
   */
  List<TreeNode> path1;
    List<TreeNode> path2;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        
        // find the paths leading to the nodes p, q from root.
        backtrack(root, p, q, new ArrayList<>());
        
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                return path1.get(i-1);
            }
        }
        
        return root;
    }
    
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        
        if(root == null) { return; }
        if(path1.size() > 0 && path2.size() > 0) { return ;}
        
        if(root.val == p.val){
            path1 = new ArrayList<>(path);
            path1.add(root);
            // add the node once more so it is easier to compare paths
            path1.add(root);
        }
        
        if(root.val == q.val){
            path2 = new ArrayList<>(path);
            path2.add(root);
            // add the node once more so it is easier to compare paths
            path2.add(root);
        }
        
        // action
        path.add(root);
        
        // recurse
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        
        // backtrack
        path.remove(path.size() - 1);
    }
}
