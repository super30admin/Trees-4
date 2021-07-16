class Solution {
private:
    int kthSmallest(TreeNode* root, int& nodeVal, int& k) {
		// Inorder traversal goes from smallest to largest. After we hit the minimum node
		// we need to then count down as we successively print bigger nodes.
		// Once k == 0, we are at the kth smallest node, so we save its value in nodeVal
        if (!root) return nodeVal;
        kthSmallest(root->left, nodeVal, k);
		// After we hit the most left node, we now need to count down.
        k--; 
        if (!k) return nodeVal = root->val;
        kthSmallest(root->right, nodeVal, k);
        return nodeVal;
    }
    
public:
    int kthSmallest(TreeNode* root, int k) {
        int nodeVal =0; // This will store out answer
        return kthSmallest(root, nodeVal, k);
    }
};
//O(n) + O(n) TC & SC
