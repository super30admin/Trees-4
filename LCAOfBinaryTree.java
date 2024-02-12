public class LCAOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorRecursive(root, p, q);
        // return lowestCommonAncestorRecursiveUsingPaths(root, p, q);
        // return lowestCommonAncestorIterativeUsingParentPointers(root, p, q);
    }

    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is height of tree
    private TreeNode lowestCommonAncestorIterativeUsingParentPointers(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode curr = stack.pop();
            if (curr.left != null) {
                stack.push(curr.left);
                parentMap.put(curr.left, curr);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                parentMap.put(curr.right, curr);
            }
        }
        List<TreeNode> ancestorsOfP = new ArrayList<>();
        while (p != null) {
            ancestorsOfP.add(p);
            p = parentMap.get(p);
        }
        while (!ancestorsOfP.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }

    List<TreeNode> pList;
    List<TreeNode> qList;
    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is height of tree
    private TreeNode lowestCommonAncestorRecursiveUsingPaths(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new ArrayList<>());
        pList.add(p);
        qList.add(q);
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).val != qList.get(i).val) {
                return pList.get(i - 1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> currPath) {
        if (root == null) return;
        currPath.add(root);
        if (root.val == p.val) {
            pList = new ArrayList<>(currPath);
        } else if (root.val == q.val) {
            qList = new ArrayList<>(currPath);
        }
        helper(root.left, p, q, currPath);
        helper(root.right, p, q, currPath);
        currPath.remove(currPath.size() - 1);
    }

    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is height of tree
    private TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return root;
        }
    }
}
