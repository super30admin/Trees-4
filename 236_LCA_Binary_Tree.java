    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    Time Complexity for operators : o(nlogn) .. n is the length of the string
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) First sort the backward array on the basis of value. (mlogm)
                    B) Then iterate thru the first array and calculate the target that we have to find in the second array.
                    C) Apply binary search on the second array with target and second array to find the element.
                    D) Once we have index of element, get the  sum and check if it is greater than max. Need to maintain max.
                    E) if sum>max then create new arraylist and add then elemnts into it.
                    F) At the end, return list.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;
        
        // if(p.val > root.val && q.val>root.val)
        //     return lowestCommonAncestor(root.right,p,q);
        // else if(p.val < root.val && q.val < root.val)
        //     return lowestCommonAncestor(root.left,p,q);
        // else
        //     return root;
        
        while(root!=null){
            if(p.val > root.val && q.val > root.val)
                root = root.right;
            else if(p.val < root.val && q.val < root.val)
                root = root.left;
            else return root;
        }
        return root;
    }
}