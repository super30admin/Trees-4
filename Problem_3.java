// Time Complexity : O(n)
// Space Complexity : O(h) -- recursive stack;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Traverse through the tree, if p and q found return node or return null to the recuresive call
//checking the returned values from left and right, backtrack if both p and q not found
//if both p and q found in tree then return intersection node

//236. Lowest Common Ancestor of a Binary Tree

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }
        else if(left != null && right == null){
            return left;
        }
        else if(left == null && right != null){
            return right;
        }
        else{
            return root;
        }
    }
}

//Recursive
// class Solution {
//     List<TreeNode> plist;
//     List<TreeNode> qlist;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null) return null;
        
//         plist = new ArrayList<>();
//         qlist = new ArrayList<>();
        
//         dfs(root, p, q, new ArrayList<>());
//         for(int i = 0; i < plist.size(); i++){
//             if(plist.get(i) != qlist.get(i)){
//                 return plist.get(i - 1);
//             }
//         }
//         return null;
//     }

//     private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//         if(root == null){
//             return;
//         }
//         path.add(root);
//         if(root == p){
//             plist = new ArrayList<>(path);
//             plist.add(root);
//         }
//         if(root == q){
//             qlist = new ArrayList<>(path);
//             qlist.add(root);
//         }

//         dfs(root.left, p, q, path);
//         dfs(root.right, p, q, path);

//         path.remove(path.size() - 1);
//     }
// }