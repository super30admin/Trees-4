/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    n - total nodes
* 
* Space Complexity: O(h)
    h - height of the binary tree
* 
*/

public class LCABinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // if root is p or q return the node
            if (root == null || root == p || root == q) {
                return root;
            }

            // check if p is found in left subtree
            TreeNode left = lowestCommonAncestor(root.left, p, q);

            // check if q is found in left subtree
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                // if both are not null, we are at LCA
                return root;
            }
        }
    }
}

/*
 * 
 * class Solution {
 * List<TreeNode> pathP;
 * 
 * List<TreeNode> pathQ;
 * 
 * boolean isPFound, isQFound;
 * 
 * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 * pathP = new ArrayList<>();
 * 
 * pathQ = new ArrayList<>();
 * 
 * isPFound = false;
 * 
 * isQFound = false;
 * 
 * preOrder(root, p, q);
 * 
 * int index = 0;
 * 
 * while(index < pathP.size() && index < pathQ.size()){
 * if(pathP.get(index).val != pathQ.get(index).val){
 * return pathP.get(index-1);
 * }
 * index++;
 * }
 * 
 * return pathP.get(index-1);
 * }
 * 
 * private void preOrder(TreeNode root, TreeNode p, TreeNode q){
 * if(root == null){
 * return;
 * }
 * 
 * if(!isPFound){
 * pathP.add(root);
 * 
 * if(root.val == p.val){
 * isPFound = true;
 * }
 * }
 * 
 * if(!isQFound){
 * pathQ.add(root);
 * 
 * if(root.val == q.val){
 * isQFound = true;
 * }
 * }
 * 
 * preOrder(root.left, p, q);
 * preOrder(root.right, p, q);
 * 
 * if(!isPFound){
 * pathP.remove(pathP.size()-1);
 * }
 * 
 * if(!isQFound){
 * pathQ.remove(pathQ.size()-1);
 * }
 * }
 * }
 * 
 */