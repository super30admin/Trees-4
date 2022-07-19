
*****102.235.Lowest Common anchestor in Binary search tree****
// Time Complexity :0(h);
// Space Complexity :0(1);
// Did this code successfully run on Leetcode :y
// Any problem you faced while coding this :n
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
        if(p.val<root.val && q.val<root.val) 
        {
            return  lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val>root.val && q.val>root.val)
        {
            return  lowestCommonAncestor(root.right, p, q);
        }
        else 
        {
            return root;
        }
        
    }
}
//103.236.LOWEST COMMON ACHESTOR IN BINARY TREE****
// Time Complexity :0(n); as we will be iterating through all the elements in the binary tree
// Space Complexity :0(2h); i.e the space for 2 list pathp and pathq for maintaining 2 paths. as the path would be max of h . now here 2 is constant so 0(h);
// Did this code successfully run on Leetcode :y
// Any problem you faced while coding this :n
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        
        pathp=new ArrayList<>();
        pathq=new ArrayList<>();
        
        //null case
        if(root==null) return null;
        
        //Calling the helper function
        helper(root, p, q, new ArrayList<>());
        
        //Finding the exact element
        for(int i=0;i<pathp.size();i++)
        {
            if(pathp.get(i)!=pathq.get(i))
            {
                return pathp.get(i-1);
            }
        }
        return null;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        //Base
        if(root==null)
        {
            return;
        }
        path.add(root);
        if(root==p)
        {
            pathp=new ArrayList<>(path);
            pathp.add(p);
        }
        
        if(root==q)
        {
            pathq=new ArrayList<>(path);
            pathq.add(q);
        }
        
        //Logic
        
        //Action
        
        //Recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        
        //Backtrack
        path.remove(path.size()-1);
    }
}
//****Kth SMALLEST ELEMENT IN BST****
//Time complexity:o(n);
//Space complexity: 0(1);
//Leetcode runnable: Y;
//Any doubts: N;

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
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
        
    }
    
    public void inorder(TreeNode root, int k)
    {
        //Base
        if(root==null)
        {
            return;
        }
        
        //logic
        inorder(root.left,k);
        count++;
        if(count==k)
        {
            result=root.val;
        }
        inorder(root.right, k);
        
    }
}
