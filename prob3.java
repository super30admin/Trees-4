// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes



class Solution {
    public static boolean getPath(TreeNode root, TreeNode n, ArrayList<TreeNode> list){
        if(root == null){
            return false;
        }

        list.add(root);

        if(root.val == n.val){
            return true;
        }
        boolean foundLeft = getPath(root.left,n,list);
        boolean foundRight = getPath(root.right,n,list);

        if(foundLeft || foundRight){
            return true;

        }
        list.remove(list.size()-1);
        return false;
       }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q,path2);

        //lca
           int i=0;
           for(; i<path1.size() && i<path2.size();i++){
               if(path1.get(i) != path2.get(i)){
                   break;
               }
           }
           TreeNode lca = path1.get(i-1);
           return lca;
    }
}