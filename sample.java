//Problem 1
// Time Complexity :O(k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt,answere;
    public int kthSmallest(TreeNode root, int k) {
      if(root==null)
      {
        return -1;
      }  
      cnt=k;
      answere=-1;
      inorder(root);
      return answere;
    }
    private void inorder(TreeNode root)
    {
        if(root ==null || answere !=-1)
        {
            return;
        }
        inorder(root.left);
        cnt--;
        if(cnt==0){
            answere=root.val;
            return;
        }
        inorder(root.right);
    }
}


//Problem 2
// Time Complexity :O(h)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        if(root == null)
        {
            return null;
        }
          int cur=root.val;
       if(cur>p.val&&cur>q.val)
       {
return lowestCommonAncestor(root.left,p,q);
       }
         if(cur<p.val&&cur<q.val)
       {
return lowestCommonAncestor(root.right,p,q);
       }
       return root;
        
    }
}
//Problem 3
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return root;
        }
        pathp=new ArrayList<>();
        pathq=new ArrayList<>();
        dfs(root,p,q, new ArrayList<>());
        for(int i=0;i<pathp.size();i++)
        {
            if(pathp.get(i)!=pathq.get(i))
            {
                return pathp.get(i-1);
            }
        }
        return null;
    }
    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {// backtracking
        // base
        if(root==null)
        {
            return;
        }
        //logic
        //undo
        path.add(root);
        if(root==p)
        {
            pathp=new ArrayList<>(path);
            pathp.add(root);
        }
        if(root==q)
        {
            pathq=new ArrayList<>(path);
            pathq.add(root);
        }
        dfs(root.left,p,q,path);
        dfs(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}