public class LCAbst {
//  recursive method: TC = O(h) SC = O(h) --> stack used under the hood
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val && q.val>root.val)return lowestCommonAncestor(root.right,p,q);
        else if(p.val<root.val && q.val<root.val)return lowestCommonAncestor(root.left,p,q);
        else{
            return root;
        }
// iterative method TC = O(h) SC = O(1) --> no stack used
//        while(true){
//            if(p.val>root.val && q.val>root.val) root = root.right;
//            else if(p.val<root.val && q.val<root.val) root = root.left;
//            else return root;
//        }
    }
}
