public class KthSmallestInBSTIntRecursiveInOrder {

        // INT RECURSIVE INORDER TRAVERSAL - O(N)

        int count;

        public int kthSmallest(TreeNode root, int k) {

            count = k;

            return inOrder(root);
        }

        // decrease count from k during inorder traversal and return root value when count becomes zero
        public int inOrder(TreeNode root) {

            //base
            if(root == null) {

                return Integer.MAX_VALUE;
            }

            //System.out.println(root.val);

            int result =  inOrder(root.left);

            if(result != Integer.MAX_VALUE) return result;

            //in order action
            count--;

            if(count == 0) {

                return root.val;
            }

            return inOrder(root.right);
        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(H)
*/