class LowestCommonAncestorBinaryT {
    /*
      Time : O(n)  | number of nodes in the tree,  
      Space : O(n) | 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // find a path and then return last common item
        TreeNode curr = root;
        
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        
        backtrack(root, p, pList);
        backtrack(root, q, qList);
        
            
        return helper(pList, qList);
    }
    
    void backtrack(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null) return;
        if(root.val == p.val){
            list.add(root);
            list.add(root);       
            return;
        }
        
        //logic
        // action
        list.add(root);
        // recurse
        backtrack(root.left, p,  list);
        backtrack(root.right, p, list);

        if(list.get(list.size() - 1) == p){
            return;
        }
        // backtrack
        list.remove(list.size() - 1);
    }
    
    TreeNode helper(List<TreeNode> small , List<TreeNode> large){
        if(small.size() > large.size()) return helper(large, small);
        
        for(int i = 0; i < small.size(); i++){
            if(large.get(i).val != small.get(i).val){
                return large.get(i - 1);
            }
        }
        return null;
    }
}
