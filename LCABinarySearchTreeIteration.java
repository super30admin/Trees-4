public class LCABinarySearchTreeIteration {

        //ITERATIVE - O(H) Time - O(1) Space

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            while(true) {

                //if both values are greater than root, move to right subtree at root
                if(p.val > root.val && q.val > root.val) {

                    root = root.right;
                }

                //if both values are smaller than root, move to left subtree at root
                else if(p.val < root.val && q.val < root.val) {

                    root = root.left;
                }

                //if one value is smaller and one is larger than root, there is divergence from that root which is LCA
                else {

                    return root;
                }

            }
        }

}

/*
TIME COMPLEXITY = O(H) = O(logN)

recursive calls in order of height of tree

SPACE COMPLEXITY = O(1)
*/