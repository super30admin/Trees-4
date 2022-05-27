/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Backtracking Solution
class Solution {
    List<TreeNode> Ppath;
    List<TreeNode> Qpath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        Ppath = new ArrayList<>();  //we declare a global variable to record the path in through which we find p and q
        Qpath = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());//we pass the arguments to our recursive function along with an empty array list to record the path
        for(int i = 0; i < Ppath.size(); i++){//once we receive the path for p and q from our helper method, we compare the  elements in both the path. Once there is a mispatch, we return the element prior to that as an ancestor should be common to both p and q
            if(Ppath.get(i) != Qpath.get(i)){
                return Ppath.get(i-1);
            }
        }
        return null;
    }
    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root == null){
            return;
        }
        //Action
        path.add(root);//we add the root node to our path
        if(root == p){  //while traversing we check if the node is qual to p, if yes, then we record the path to which we found p, if not, then we keep on traversing and add the nodes to our path list
            Ppath = new ArrayList<>(path);
            Ppath.add(root);    //we add an extra node to our list to avoid to deal with null case. Example: ppath = [3] and qpath = [3,2,1]
        }
        if(root == q){
            Qpath = new ArrayList<>(path);
            Qpath.add(root);
        }
        //Recurse
        helper(root.left, p, q, path);//we call our function recursively until we find p and q
        helper(root.right, p, q, path);
        //Backtrack
        path.remove(path.size() - 1);   //once we hit null, we know that p cannot be more down the tree hence we backtrack and remove the elements from our path
    }
}


//Bottom Up Recursion Solution

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
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);  //we store the left recursion in left treenode
        TreeNode right = lowestCommonAncestor(root.right, p, q);    //right recursion in right treenode

        if(left == null && right == null){//we apply multiple cases keeping the output in mind and use bottom up recursion to return the desired output
            return null;
        }
        else if(left == null && right != null){
            return right;
        }
        else if(left != null && right == null){
            return left;
        }
        else{
            return root;
        }
    }
}