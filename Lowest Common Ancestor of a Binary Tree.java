//Time Complexity : O(n)
//Space Complexity : O(h) h is height of the tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case : if root is either p or q or null return root
        if(root==null||root==p||root==q){
            return root;
        }
        //locate the p and q on both the sides
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //if both the nodes are found on the same suntree then return their ancestor which its parent
        if(left!=null && right!=null){
            return root;
        }
        //found on the left
        else if(left!=null){
            return left;
        }
        //found on the right
        else{
            return right;
        }
    }
}
//Backtrack approach
//Time Complexity : O(n)
//Space Complexity : O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        backtrack(root,p,path1);
        backtrack(root,q,path2);
        for(int i=0;i<path1.size();i++){
            if(path1.get(i) != path2.get(i)){
                return path1.get(i-1);
                //IF P = 7 AND q = 4, then path1 = {3,5,2,7,7} and path2 = {3,5,2,2} here there will be mismatch at the last element so the previous element is returned
            }
        }
        return null;
    }
    private void backtrack(TreeNode root, TreeNode p,List<TreeNode> path){
        if(root==null){
            return;
        }
        if(root==p){
            path.add(p);
        }
        //ACTION: add the node twice inorder to get the correct value that lies just before this
        path.add(root);
        //RECURSE : Left subtree
        backtrack(root.left,p,path);
        //if the last node is reached, and if its p then return and the right side is not explored
        if(path.get(path.size()-1)==p){
            return;
        }
        //RECURSE : Right subtree
        backtrack(root.right,p,path);
        //if the last node is reached, and if its q then return and further is noth explored
        if(path.get(path.size()-1)==p){
            return;
        }
        //Backtrack
        path.remove(path.size()-1);
    }
}