// Time Complexity : O(n) -> since the entire tree is being traversed until pathQ and pathP are not null.
// Space Complexity : O(H) -> 
        //At each node we are maintaing a path to reach that node. At node at the base level will have path containing H(Height) nodes.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



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

        //base case
        if(root == null){
            return null;
        }

        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();

        recurse(root, p, q, new ArrayList<>());

        int ptrP = 0;
        int ptrQ = 0;

        while(pathP.get(ptrP).val == pathQ.get(ptrQ).val){
            ptrP++;
            ptrQ++;
        }
        
        return pathP.get(ptrP - 1);
    }

    private void recurse(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){

        if(root == null || (pathP.size() > 0 && pathQ.size() > 0)){
            return;
        }
        
        //check if root is either p or q
        //if yes the update PathP or pathQ respectively

        //action
        path.add(root);

        if(root.val == p.val){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }

        if(root.val == q.val){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        //recurse step
        recurse(root.left, p, q, path);
        recurse(root.right, p, q, path);

        //backtrack
        path.remove(path.size() - 1);

    }
}