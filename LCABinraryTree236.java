// Time Complexity : O(n)
// Space Complexity : O(h)
//    where h : Height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Traverse the tree using following conditions :- 
1st Approach:
.Maintain two lists for both the paths and iterate through the list and 
return wherever it has not equal nodes return its previous values

2nd approach
 *  1) If root value is equal to p or q then return root. 
 *  2) Traverse the left and right subtrees. 
 *  3) If both left and right subtree return valid pointer then return root else return not null right or left node.
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
        if(root == null){
            return root;
        }
        backtrack(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size(); i++){
            if(pathP.get(i)!=pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
        
    }
    void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        if(root == null){
            return;
        }
        path.add(root);
        if(root == p){
            pathP = new ArrayList(path);
            pathP.add(p);
        }
        if(root ==q){
            pathQ = new ArrayList(path);
            pathQ.add(q);
        }
        backtrack(root.left,p,q,path);
        backtrack(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}
