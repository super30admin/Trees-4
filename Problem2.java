public class Problem2 {
    class recursive {
        //t.c ->  O(h)
        //s.c -> O(h)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
            if(root.val< p.val && root.val < q.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            else if(root.val >  p.val && root.val > q.val){
                return lowestCommonAncestor(root.left,p,q);
            }
            else{
                return root;
            }

        }
    }
    class iterative {
        //t.c ->  O(h)
        //s.c -> O(1)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
            while(true){
                if(root.val<p.val && root.val <q.val){
                    root = root.right;
                }
                else if(root.val > p.val && root.val > q.val){
                    root = root.left;
                }
                else{
                    return root;
                }
            }

        }
    }
}
