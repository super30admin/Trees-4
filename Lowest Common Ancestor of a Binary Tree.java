/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //recurssion brute force with backtracking solution- TC- O(n) traversing whole tree, sc-O(2n) 2 times of height 
 //we are maintaing 2 list for p and q
 //maintain 2 lists one for if we find p deep copy in listp and second list if we find q deep copy in listq and 
 //return ele just before we find uncommonality in both lits, when we find p or q add it 2 times to find uncommonality easier
// class Solution {
//     List<TreeNode> pathP;
//     List<TreeNode> pathQ;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         pathP = new ArrayList<>();
//         pathQ = new ArrayList<>();

//         helper(root, p, q, new ArrayList<>());

//         for(int i= 0; i < pathP.size(); i++){//we can take any list p or q because we have added 2 ps and q at the end,
//         //it will always stop before
//         if(pathP.get(i) != pathQ.get(i)){
//             return pathP.get(i-1);
//         }

//         }
//         return null;
        
//     }

//     private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//         //base
//         if(root == null) return;

//         //action
//         path.add(root);
//         if(root == p){//we compare nodes to handel duplicate values
//             pathP = new ArrayList<>(path);
//             pathP.add(root);
//         }
//         if(root == q){
//             pathQ = new ArrayList<>(path);
//             pathQ.add(root);
//         }

//        //recurssion
//         helper(root.left, p, q, path);
//         helper(root.right, p, q, path);

//         //backtrack
//         path.remove(path.size()-1);

//     }
// }

// //using pathP, pathQ as local variables
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         List<TreeNode> pathP = new ArrayList<>();
//         List<TreeNode> pathQ = new ArrayList<>();

//         helper(root, p, q, new ArrayList<>(), pathP, pathQ);

//         for(int i= 0; i < pathP.size(); i++){//we can take any list p or q because we have added 2 ps and q at the end,
//         //it will always stop before
//         if(pathP.get(i) != pathQ.get(i)){
//             return pathP.get(i-1);
//         } 

//         }
//         return null;
        
//     }
//     private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path, List<TreeNode> pathP, List<TreeNode> pathQ){
//         //base
//         if(root == null) return;

//         //action
//         path.add(root);
//         if(root == p){//we compare nodes to handel duplicate values
//             //pathP = new ArrayList<>(path);//creating again new reference for pathP it will not get back same in main
//             //where there is already a refence, so here just pass path not deep copy
//             pathP.addAll(path);
//             pathP.add(root);
//         }
//         if(root == q){
//             pathQ.addAll(path);
//             pathQ.add(root);
//         }

//        //recurssion
//         helper(root.left, p, q, path, pathP, pathQ);
//         helper(root.right, p, q, path, pathP, pathQ);

//         //backtrack
//         path.remove(path.size()-1);

//     }
// }

//using bottom to top approach tc-O(n) sc-O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null;//return null back to node where it called from
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return root;


        
    }
   
}