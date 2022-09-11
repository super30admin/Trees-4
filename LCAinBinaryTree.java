//Important Algorithm ****
//Approach -  3 : Recursion
//Time Complexity : O(n)
//Space Complexity : O(h)

class Solution {
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,  p,  q);
        TreeNode right = lowestCommonAncestor(root.right,  p,  q);
        
        if(left == null && right == null) return null; // not found
        else if(left == null && right != null) return right; //left side
        else if(left != null && right == null) return left; // right side 
        else return root; // p, q are both sides

    }
}


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



class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    boolean flagP;
    boolean flagQ;
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
            flagP = true;
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){
            flagQ = true;
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        
        //If both are found on left or right no need to go other side
        //Recurse
        if(!flagP || !flagQ)
            helper(root.left,  p, q, path);
        //st pop
        if(!flagP || !flagQ)
          helper(root.right, p, q, path);
        //st pop
        
        //BackTrack
        path.remove(path.size()-1);
  
    }
    
}

