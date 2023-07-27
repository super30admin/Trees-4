public class LCABinarySearchTreeRecursion {

        //RECURSIVE - O(H) Time - O(H) Space

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            //if both values are greater than root, move to right subtree at root
            if(p.val > root.val && q.val > root.val) {

                return lowestCommonAncestor(root.right, p, q);
            }

            //if both values are smaller than root, move to left subtree at root
            else if(p.val < root.val && q.val < root.val) {

                return lowestCommonAncestor(root.left, p, q);
            }

            //if one value is smaller and one is larger than root, there is divergence from that root which is LCA
            else {

                return root;
            }

        }

}

/*
TIME COMPLEXITY = O(H) = O(logN)

recursive calls in order of height of tree

SPACE COMPLEXITY = O(H) = O(logN)

recursive stack space is height of tree
*/