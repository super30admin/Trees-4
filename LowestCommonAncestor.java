// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Time Complexity: O(n)
// Space Complexity: O(n)

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
    List<TreeNode> pPath;
    List<TreeNode> qPath;
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p , q, new ArrayList<>());
        // System.out.println("qPath");
        // for (int i = 0; i < qPath.size(); i++) {
        //     System.out.print(qPath.get(i).val);
        // }
        // System.out.println("pPath");
        // for (int i = 0; i < pPath.size(); i++) {
        //      System.out.print(pPath.get(i).val);
        // }
        int i = 0; int j = 0;

        while(i != pPath.size() && j != qPath.size()){
            if(pPath.get(i) != qPath.get(j)){
                result = pPath.get(i - 1);
                break;
            }
            i++;
            j++;
        }
        return result;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;

        //logic
        path.add(root);
        if(root == p){
            pPath = new ArrayList<>(path);
            pPath.add(root);
        }
        if(root == q){
            qPath = new ArrayList<>(path);
            qPath.add(root);
        }
        helper(root.left, p, q, new ArrayList<>(path));
        helper(root.right, p ,q, new ArrayList<>(path));
    }
}