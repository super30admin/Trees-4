import java.util.Stack;

public class KthSmallestInBSTIterativeInOrder {

        // ITERATIVE INORDER TRAVERSAL - O(N)

        public int kthSmallest(TreeNode root, int k) {

            Stack<TreeNode> st = new Stack<>();

            while(root != null || !st.isEmpty()) {

                while(root != null) {

                    st.push(root);

                    root = root.left;
                }

                TreeNode pop = st.pop();

                k--;

                if(k == 0) {

                    return pop.val;
                }

                root = pop.right;
            }

            return 9999;
        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(H)
*/