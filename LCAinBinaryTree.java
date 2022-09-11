//Approach - 1 : Backtracking
//Time Complexity : O(n)
//Space Complexity : O(h)

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root, p, q, new ArrayList<>());
      
        for(int i = 0; i < pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1); // last before value
            }
        }
        return null;
    }

    
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        
       
        
        //logic  
        //Backtracking
        //Action
        path.add(root);
        
         if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        //Recurse
        helper(root.left,  p, q, path);
        //st pop
        helper(root.right, p, q, path);
        //st pop
        
        //BackTrack
        path.remove(path.size()-1);
  
    }
    
}

