public class KthSmallestInBSTVoidRecursiveInOrder {

        // VOID RECURSIVE INORDER TRAVERSAL - O(N)

        int count;
        int result;
        boolean flag;

        public int kthSmallest(TreeNode root, int k) {

            count = k;

            inOrder(root);

            return result;

        }

        // decrease count from k during inorder traversal and return root value when count becomes zero
        public void inOrder(TreeNode root) {

            //base
            if(root == null) {

                return;
            }

            System.out.println(root.val);

            if(!flag) {

                inOrder(root.left);
            }

            //in order action
            count--;

            if(count == 0) {

                flag = true;
                result = root.val;
            }

            if(!flag) {

                inOrder(root.right);
            }

        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(H)
*/