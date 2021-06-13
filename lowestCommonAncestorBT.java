//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Logic Iterate in preorder fashion and see where the value of p,q would lie and then recursively calling and trying to build a path for p and q nodes. After we have the path, we try to see what are the common parents of both p and q and the ith index where the parents are different, we return the i - 1 value.
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    boolean flagP;
    boolean flagQ;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        
        
        helperPath(root,p,q,new ArrayList<TreeNode>(),new ArrayList<TreeNode>());
       // helperPath(root,q);
      //  System.out.println(pathP);
        for(int i = 0; i < pathQ.size(); i ++){
            
            TreeNode temp = pathQ.get(i);
         //   System.out.println(temp.val);
        }
      //  System.out.println(pathQ);
        int i = 0;
        int size = 0;
        if(pathP.size() > pathQ.size()){
            
            size = pathQ.size();
        }
        else{
            size = pathP.size();
        }
        while(i < size){
            
            if(pathP.get(i) == pathQ.get(i)){
                
                while(pathP.get(i) == pathQ.get(i)){
                  //  System.out.println("hitting");
                    i ++;
                }
                 return pathP.get(i - 1);
                
            }
          
            
            i ++;
        }
            
            
        
        
        return null;
    }
    
    private void helperPath(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> pathP1, List<TreeNode> pathQ1){
        
        if(root == null){
            
            return;
        }
        
        //action
        if(root.val == p.val){
            
           // pathP.add(new ArrayList<TreeNode>());
          //   System.out.println(p.val);
             pathP1.add(root);
             pathP1.add(root);
            pathP = new ArrayList<>(pathP1);
            flagP = true;
        }
        if(root.val == q.val){
             pathQ1.add(root);
             pathQ1.add(root);
           // pathP.add(new ArrayList<TreeNode>());
          //   System.out.println(p.val);
            pathQ = new ArrayList<>(pathQ1);
            flagQ = true;
        }
        if(flagP && flagQ){
            
            return;
        }
        pathP1.add(root);
         pathQ1.add(root);
        //recurse
        helperPath(root.left,p,q,pathP1,pathQ1);
        helperPath(root.right,p,q,pathP1,pathQ1);
        //backtrack
        pathP1.remove(root);
         pathQ1.remove(root);
    }
}