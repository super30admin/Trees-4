public class LCABST {

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    /*  LCA - Parents of child nodes are called ancestors. now 3 4 5 the lowest common ancestors is the closest parent
     * A node can be called ancestor of its itself.
    * For BST we use the property where left<root<right. We compare targets if one is less than root and another > root
    * then we return that parent.
    * We keep traversing till we reach leaf node as we won't be able to move ahead.
    *
    * TC - O(h)
    * SC - O(1)
    * */

//[6,2,8,0,4,7,9,null,null,3,5]

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

        System.out.println(lowestCommonAncestor(root,p,q));

    }
//Iterative approach
public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null) return null;
   while (true){
       if(root.val> p.val&&root.val>q.val) root = root.left;
       else if (root.val<p.val&&root.val<q.val) root = root.right;
       else return root;
   }
}
    //Recursive Approach
/*  * TC - O(h)
    * SC - O(h)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>p.val&& root.val> q.val){
            return  lowestCommonAncestor(root.left,p,q);
        } else if (root.val<p.val && root.val<q.val ) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
*/

}
