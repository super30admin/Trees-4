public class LCABinaryTreeBottomUp {

        //Bottom Up Recursion - No path maintenance

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            //base
            // return to root (terminate recursion)if root is null or p or q
            if(root == null || root == p || root == q) {

                return root;
            }

            //System.out.println(root.val); //print to understand recursion

            //logic
            TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
            TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

            // if both subtrees have null, return null
            if(leftLCA == null && rightLCA == null) {

                return null;
            }

            // return non-null subtree ancestor
            else if(leftLCA == null && rightLCA != null) {

                return rightLCA;
            }

            else if(leftLCA != null && rightLCA == null) {

                return leftLCA;
            }

            // return root, if both subtrees have non-null (different) ancestors indicating root is the common ancestor
            else {

                return root;
            }

        }

}
/*
TIME COMPLEXITY = O(N)

traversing all tree nodes in binary tree potentially = O(N) -
if two target tree nodes are leftmost and rightmost leaves

SPACE COMPLEXITY = O(H) = O(N) in worst case

recursive stack space = height of tree
*/