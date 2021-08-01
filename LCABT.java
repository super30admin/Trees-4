class LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> traverse = new ArrayDeque<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        parent.put(root, null);
        traverse.push(root);

        while (!map.containsKey(p) || !map.containsKey(q)) {

            TreeNode traverse = stack.pop();

            if (node.left != null) {
                map.put(node.left, node);
                traverse.push(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                traverse.push(node.right);
            }

        }

    }
}