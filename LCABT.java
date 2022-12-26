public class LCABT {

    //https://www.youtube.com/watch?v=k-dwBgI3I5Q



    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

     //   System.out.println(lowestCommonAncestor(root,p,q));

    }
    // TC - O(n)
    //SC - O(h)
    //BottomUp approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root ==p || root == q ) return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left==null && right ==null) return null;
        else if (left!=null&& right == null) return left;
        else if (left==null && right !=null) return right;
        else return root;
    }


//Top Down/ Normal Recursion
    /*
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        pathP = new ArrayList<>();
        pathQ= new ArrayList<>();
        dfs(root, p, q , new ArrayList<>());
        for(int i = 0; i<pathP.size();i++){
            if(pathP.get(i)!= pathQ.get(i)) return pathP.get(i-1);
        }
        return null;
    }
    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root==null) return;
        path.add(root);
        if(root ==p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root ==q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        dfs(root.left,p,q,path);
        dfs(root.right,p,q,path);
        path.remove(path.size()-1);


    }*/
}
