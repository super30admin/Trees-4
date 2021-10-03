
// Time Complexity : O(H)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope

// brute force approach
// Your code here along with comments explaining your approach

// brute force approach
/*Approach:
1) trace paths from root to p and root to q
2) store them in path1 and path2 respectively
3) Push last node twice to avoid mismatch
4) wherever the mismatch occurs (compare each elements in lists) and get one node value previous to mismatch
*/

import java.util.*;
class LowestCommonAncestorInBT {


    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    
    List<TreeNode> path1;
    List<TreeNode> path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
        {
            return root;
        }
        
        
        path1= new ArrayList<>();
        path2 = new ArrayList<>();
        
        
        // store the paths by traversing
        backtrack(root,p,q,new ArrayList<>()); // require a local arraylist to remove elements after every recurisve call
         
        
        for(int i=0;i<path1.size();i++)
        {
            if(path1.get(i)!=path2.get(i))
            {
                return path1.get(i-1);
            }
            
        }
        
        return null;
    }
    
    public void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> res)
    {
        
        // base case
        if(root==null)
        {
            return;
        }
        // root equals p
        // add the last node twice to avoid mismatch
        if(root==p)
        {
            path1= new ArrayList<>(res);
            path1.add(p);
            path1.add(p);
            
        }
        
        // add last node twice to avoid mismatch
        if(root==q)
        {
            
            path2 = new ArrayList<>(res);
            path2.add(q);
            path2.add(q);
        }
        
        
        
        //logic
        //action
        res.add(root);
        //recurse
        backtrack(root.left,p,q,res);
        backtrack(root.right,p,q,res);
        //bactrack
        
        res.remove(res.size()-1);
        
        
        
    }
    
}