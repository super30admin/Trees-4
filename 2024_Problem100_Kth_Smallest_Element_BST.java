//230. Kth smallest element in BST - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
//Time Complexity: O(n* log(k))
//Space Complexity: O(h)

//Brute Force (using Heaps)
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        Queue<TreeNode> queue = new LinkedList<>();
        //MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode dummy = queue.poll();
                pq.add(dummy.val);
                if(dummy.left != null){
                    queue.add(dummy.left);
                }
                if(dummy.right != null){
                    queue.add(dummy.right);
                }
            }
        }

        for(int i=1; i<k; i++){
            if(i==k){
                return pq.poll();
            }
            pq.poll();
        }

        return pq.poll();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(h)
//Optimal - Iterative
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        //processing in in-order traversal
        while(!st.isEmpty() || root != null){
            while(root != null){ //processing left
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0) return root.val; //processing root
            root = root.right;
        }

        return -1;
    }
}

//Follow up
//Time Complexity: O(h) ~ height of the tree

// We need to maintain the number of left subtree children count with the root node to know how many element are present
//       in the left subtree. Eg., for the leaf nodes, the count will be 0 as there are no children to the leaf nodes.
//
//                [6]100
//               /        \
//          [3]50       [1]150
//           /    \      /     \
//        [1]20    80    120   180
//         /  \     \
//        10   30   90
//
// Kth smallest element: 4th smallest
//              4 < 6 : therefore, definitely the 4th smallest is on the left subtree
//              3 count in the root there are 3 nodes in the left subtree. So, 3+1 = root
//              Thus, 4th smallest element is 50.
// Kth smallest element: 8th smallest
//              6+1 < 8: Therefore, the 8th smallest element is on the right subtree.
//              8 - 7 = 1; 1st smallest element on the right.
//              150 has a count of 1; which denotes there is 1 element on the left (smaller to 150)
//              Thus, 8th smallest element is 120.
// Insertion: O(log(n)): add node in the BST [add 65]
//              65 < 100; it should be in left subtree -> increase the counter by 1
//              [6+1]100
//               /        \
//          [3]50       [1]150          //no +1 on 50 as the node is added to the right
//           /    \      /     \
//        [1]20    80    120   180      //as the node is added to the left of 80, increament count 0 -> 1
//         /  \     \
//        10   30   90
//
//
//                [7]100
//               /        \
//            [3]50       [1]150
//           /      \      /     \
//        [1]20    [1]80  120     180
//         /  \     /  \    \       \
//        10   30  65    90  130    200
//
// Deletion: Delete 150
//              According to the inorder predecessor rule, [10, 20, 30, 50, 100, 120, 130, 150, 180, 200], either replace
//              with 130 or 180 and keep decrementing the count.
//
//                [7]100
//               /        \
//            [3]50       [1]150
//           /      \      /     \
//        [1]20    [1]80  120     180
//         /  \     /  \    \       \
//        10   30  65    90  130    200
//              Traverse to the right most node of left subtree and take the value
//              150 is replaced by 130.
//                [7]100
//               /        \
//            [3]50       [1]130
//           /      \      /     \
//        [1]20    [1]80  120     180
//         /  \     /  \           \
//        10   30  65    90         200