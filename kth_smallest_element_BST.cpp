// Time Complexity : O(nlogk)
// Space Complexity : O(n+k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//BFS approach
//1. Add the elements level wise in the queue of Treenodes
//2. Add the value of each node in max_heap. Pop maximum element when the size is greater than k.
//3. At the end return the top most element.
class Solution {
public:
    
    int kthSmallest(TreeNode* root, int k) {
        //edge
        if(root ==NULL ||k==0) return 0;
        //logic
        priority_queue<int> maxq; //max_heap
        queue<TreeNode*> pq;
        maxq.push(root->val);
        pq.push(root);
        while(!pq.empty()){
            int size= pq.size();
            while(size>0){
                TreeNode* temp = pq.front();
                pq.pop(); size--;
                if(temp->left!=NULL){
                    maxq.push(temp->left->val);
                    pq.push(temp->left);
                }
                if(temp->right!=NULL){
                    maxq.push(temp->right->val);
                    pq.push(temp->right);
                }
                if( maxq.size()>k && !maxq.empty())  maxq.pop();
            }
        }
        return  maxq.top();
    }
};
// Time Complexity : O(nlogk)
// Space Complexity : O(h+k) //h-being auxillary space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//DFS approach with heap
//1. Iterate through the tree
//2. Add the value of each node in max_heap. Pop maximum element when the size is greater than k.
//3. At the end return the top most element.

class Solution {
public:
    priority_queue<int> maxq; //max_heap
    int kthSmallest(TreeNode* root, int k) {
        //edge
        if(root ==NULL ||k==0) return 0;
        //logic
        dfs(root, k);
        return  maxq.top();
    }
    
    void dfs(TreeNode* root, int k){
        //returning condition
        if(root==NULL) return;
        //logic
        maxq.push(root->val);
        //traverse
        if( maxq.size()>k && !maxq.empty())  maxq.pop();
        dfs(root->left, k);
        dfs(root->right, k);
    }
};

// Time Complexity : O(n)
// Space Complexity : O(h) //n-being auxillary space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//DFS approach with variable
//1. Iterate through the tree
//2. Decrement count value for each element processed.
//3. When count is 0 return the node value.
class Solution {
public:
    int count, element;
    int kthSmallest(TreeNode* root, int k) {
        //edge
        if(root ==NULL ||k==0) return 0;
        //logic
        count=k;
        inorder(root, k);
        return  element;
    }
    
    void inorder(TreeNode* root, int k){
        //returning condition
        if(root==NULL || count==0) return;
        
        //traverse
        inorder(root->left, k); //element being processed in the left side of the tree.
        //logic
        count--;
        if(count ==0){
            element = root->val;
            return;
        }
        inorder(root->right, k);
    }
};
