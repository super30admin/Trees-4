// TC: O(N)
// SC: O(H)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
       // base
        if (root == null || root == p || root == q)
            return root;
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null ) 
            return null;
        if ( left != null && right != null) 
            return root;   
       return ( left != null)? left : right; 
    }
}


// TC: O(N), N -> no. of nodes in the tree
// SC: O(N), N -> no. of nodes in the tree
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
//        List<TreeNode> path1 = new ArrayList();
//        List<TreeNode> path2 = new ArrayList();
//        backtrack(root, p, path1);
//        backtrack(root, q, path2);
     
//        for (int i = 0; i < path1.size(); i++)
//        {
//            if (path1.get(i) != path2.get(i))
//                return path1.get(i-1);
//        }
//        return null;
//     }
//     private void backtrack(TreeNode root, TreeNode target, List<TreeNode> path)
//     {
//         //base
//         if ( root == null )
//             return;
//         if (root == target)
//         {
//             path.add(root);
//             path.add(root);
//             return;
//         }
            
//         //logic
//         //action
//         path.add(root);
        
//         //recurse
//         backtrack(root.left, target, path);
//         backtrack(root.right, target, path);
        
//         if (path.get(path.size() - 1) == target)
//                 return;
        
//         //backtrack
//         path.remove(path.size()-1);
//     }
// }
