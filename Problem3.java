//Time complexity: O(N), where N is number of nodes in binary tree.
//Space complexity: O(N) 

class Solution {

    private static int BOTH_PENDING = 2;
    private static int LEFT_DONE = 1;
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();

        stack.push(new Pair<TreeNode, Integer>(root, Solution.BOTH_PENDING));

        boolean one_node_found = false;

        TreeNode LCA = null;

        TreeNode child_node = null;

        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            if (parent_state != Solution.BOTH_DONE) {

                if (parent_state == Solution.BOTH_PENDING) {

                    if (parent_node == p || parent_node == q) {
                        if (one_node_found) {
                            return LCA;
                        } else {
                            one_node_found = true;
                            LCA = stack.peek().getKey();
                        }
                    }

                    child_node = parent_node.left;
                } else {
                    child_node = parent_node.right;
                }
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, Solution.BOTH_PENDING));
                }
            } else {.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }

        return null;
    }
}