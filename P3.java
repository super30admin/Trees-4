/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time- o(h)
//space-  o(h)

class Solution {
    ArrayList<TreeNode> listp;
    ArrayList<TreeNode> listq;
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         listp =  new ArrayList<>();
         listq=  new ArrayList<>();
         helper(root, p, listp);
         helper(root, q, listq);
         
        //3457
        //345
        
        System.out.println(listp);
        System.out.println(listq);
        int i=0, j=0;
        while( i< listp.size() && j<listq.size() )
        {
            if(listp.get(i) == listq.get(j))
            {
                result = listp.get(i) ;   
            }
            else
            {
                break;
            }
            
            i++;
            j++;
        }
        return result;
    }
    
    public void helper(TreeNode root, TreeNode node, ArrayList<TreeNode> path)
    {
        //base
        if(root == null) return;
        if(root== node)
        {
            path.add(root);
            return;
        }
        //action
        path.add(root);//3,5,1,0,8
        
        
        //recurse
        helper(root.left, node, path);
        helper(root.right, node, path);
        
         //if last node added to path, is my node that we are searching for, we stop recursion,
        //as we have our path and return
         if(path.get(path.size()-1)== node)
         {
             return;
         }
       
        
        //backtrack      
       path.remove(path.size()-1);        
        
    }
}