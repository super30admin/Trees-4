package kThSmallest;

//Here, we use iterative in-order traversal to find the Kth smallest element.
//The iterative approach allows to perform conditional recursion using iteration with which only the necessary operations can be performed.
//Time Complexity: O(n) where n is the number of nodes in the tree.
//Space Complexity: O(h) where h is the stack space.

// This is controlled iterative recursion using stack.
//we exit the program when we find the element, no need to recursively go back like in regular recursion, here we are not processing the stack even if has elements,
//we exit beause we got the kth smallest element

//advantages of iterative solution -- right recursive calls happen very less no ned of flag here as compared to earlier -- lot of recursive calls are saved -- controlled recursion


class Iterative {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack();
        st.push(root);

        while(!st.isEmpty()) {

            // inorder(root.left)
            while(root != null) {
                st.push(root);
                root = root.left;
            }

            // top stack in new root.
            root = st.pop();
            k--;

            if(k == 0) {
                return root.val;
            }

            root = root.right;
        }

        return 0;
    }
}