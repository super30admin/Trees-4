/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  Time Complexity: O(n)
//  Space Complexity: O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
        
    }
}


//  Time Complexity: O(n)
//  Space Complexity: O(h)
class Solution {
    List<TreeNode> p1;
    List<TreeNode> q1;
    List<TreeNode> list;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        list = new ArrayList<TreeNode>();
         inorder(root,p,q);
         TreeNode res = null;
         int i=0;
         for(; i< p1.size() && i< q1.size(); i++){
             if(p1.get(i) != q1.get(i)) return p1.get(i-1);
         }
         return p1.get(i-1);
    }

    public void inorder(TreeNode root, TreeNode p, TreeNode  q){
        if(root != null){
            
            list.add(root);
            if(root == p ){
                p1 = new ArrayList<>(list);
            }
            if(root == q){
                q1 = new ArrayList<>(list);
            }

            if(p1 == null || q1 == null)
                inorder(root.left, p, q);

            if(p1 == null || q1 == null)
                inorder(root.right, p, q);

            list.remove(list.size()-1);
        }
    }
}