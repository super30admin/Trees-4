// Time Complexity : O(n+2h) in worst case h === n so O(n)
// Space Complexity :O(h) --> O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
//Using DFS get path of p and q from root node . name it pathp,pathq. now compare element at pathp[i] and pathq[i] the moment values doesnt match it means previous node was lowest ancestor of both the nodes. //Note there might be a case like we are looking for lowest ancestor of (2,4) then  pathp = [3,5,2] pathq = [3,5,2,4]   here it will never come to a situation where element doesn't match as pathp will will reach to end. so just to avoid such situation we will add p n q twice now pathp = [3,5,2,2] and pathq = [3,5,2,4,4] so now at index 3 pathP[3] != pathQ[3] hence return pathP[i-1] i.e pathp[2] 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
      
        dfs( root,  p ,q, new ArrayList<>());
    
        int i =0 ; 
        while(pathP.size() > 0 && pathQ.size()>0 && i < pathP.size()-1 && i < pathQ.size()-1
              && pathP.get(i) == pathQ.get(i))
        {
            i++;
        }
        
        return pathP.get(i-1);
    }
    
    public void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list)
    {
        //Base 
        if(root == null) return ;
        
        // if found p then add it in list and assign it to pathq afer assigning remove p from list (since added twice hence dont' forget to remove twice)
        if(root.val == p.val)
        {
            list.add(p);
              list.add(p);
            pathP =  new ArrayList<>(list);
             list.remove(list.size()-1);
             list.remove(list.size()-1);
        }
        
         if(root.val == q.val)
        {
            list.add(q);
             list.add(q);
              pathQ =  new ArrayList<>(list);
              list.remove(list.size()-1);
              list.remove(list.size()-1);
        }
        
        list.add(root);
        dfs(root.left,p,q,list);
        dfs(root.right,p,q,list);
        
        list.remove(list.size()-1);
            
    }
}