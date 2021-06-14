
//Time: O(2n)-> O(n) where n = number of nodes
//Space: O(h) where h = height of tree
//Did it run successfully on leetcode: yes
class LowestCommonAncestorOfBinaryTree {
    //list to store path of two input nodes
    List<TreeNode> path1, path2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //initializing both the paths
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        //updating path for node p
        helper(root, path1, p);
        //updating path for node q
        helper(root, path2, q);
        //looping through the path
        for(int i=0; i<path1.size(); i++){
            //if current node in path differs
            if(path1.get(i) != path2.get(i)){
                //the previous node is the ancestor
                return path1.get(i-1);
            }


        }

        return null;

    }
    public void helper(TreeNode root, List<TreeNode> path, TreeNode p) {

        //base
        //return ifroot is null
        if(root==null) return;
        //if node found
        if(root==p){
            //add to path twice to avoid path of smaller lengths and return
            path.add(root);
            path.add(root);
            return;
        }
        //logic
        //action
        //add current root to path
        path.add(root);
        //look for node on the left
        helper(root.left, path, p);
        //look for node on the right
        helper(root.right, path, p);
        //if node found, return
        if(path.get(path.size()-1)==p) return;
        //backtrack
        path.remove(path.size()-1);
    }
}