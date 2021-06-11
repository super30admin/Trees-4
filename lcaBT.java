import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



public class lcaBT {
    class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

         List<TreeNode> path1;
         List<TreeNode> path2;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            path1=new ArrayList<>();
            path2=new ArrayList<>();
            backtrack(root,p,path1);
            backtrack(root,q,path2);
            
            for(int i=0;i<path1.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    return path2.get(i-1);
                }
            }
            return null;
        }
        
        private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path){
            // base case
             if(root==null)
                 return;
            if(root==p){
                path.add(root);
                path.add(root);
                return;
            }
            
            //logic
            
            //action
            path.add(root);
            
            //recurse
            backtrack(root.left,p,path);
             backtrack(root.right,p,path);
            if(path.get(path.size()-1)==p){
                return;
            }
            
            //backtrack
            path.remove(path.size()-1);
            
         
        }
}
