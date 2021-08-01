class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> answer = inOrderTraversal(root, new ArrayList<Integer>());
        return answer.get(k - 1);
    }

    private ArrayList<Integer> inOrderTraversal (TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
        return list;
    }
}