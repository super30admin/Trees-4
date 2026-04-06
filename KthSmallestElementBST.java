class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// O(n) time, O(n) space
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         List<Integer> ans = new ArrayList<>();
//         inorder(root, ans);
//         return ans.get(k-1); // k-1 since 1-indexed, list is 0-indexed        
//     }

//     public void inorder(TreeNode root, List<Integer> ans) {
//         if (root == null) return;

//         inorder(root.left, ans);
//         ans.add(root.val);
//         inorder(root.right, ans);
//     }
// }

// O(n) time, O(h) space
class Solution {
    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    public int inorder(TreeNode root, int k) {
        if (root == null) return 0;

        inorder(root.left, k);

        count++;
        if (count == k) {
            ans = root.val;
            return ans;
        }

        inorder(root.right, k);

        return ans;
    }
}
