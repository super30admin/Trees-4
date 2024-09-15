from collections import deque
import heapq

class Solution:
	def kthSmallest1(self, root: TreeNode, k: int) -> int:
		# Time Complexity : O(n) where n is the number of elements in the tree
		# Space Complexity : O(n) where n is the number of elements in the tree because we are storing all the elements of the tree in the list
		res = []
		def inorder(root, res):
			if root != None:
				inorder(root.left, res)
				res.append(root.val)
				inorder(root.right, res)
		inorder(root, res)
		return res[k - 1]
	
	def kthSmallest(self, root: TreeNode, k: int) -> int:
		# Time Complexity : O(nlogn) + O(klogn) because we are adding every element into the queue and a priority queue
		# Space Complexity : O(n) we are maintaining a priority queue of size n
		# Have a min heap of size n and pop k elements at the end to get the kth smallest element
		pq = []
		queue = deque()
		queue.append(root)
		heapq.heappush(pq, root.val)
		while len(queue) > 0:
			temp = queue.popleft()
			if temp.left != None:
				queue.append(temp.left)
				heapq.heappush(pq, temp.left.val)
			if temp.right != None:
				queue.append(temp.right)
				heapq.heappush(pq, temp.right.val)
		i = 0
		while i < k:
			res = heapq.heappop(pq)
			i += 1
		return res

	def kthSmallest(self, root: TreeNode, k: int) -> int:
		# Time Complexity : O(nlogk) because we are adding every element into the queue and a priority queue
		# Space Complexity : O(k) we are maintaining a priority queue of size k
		# Have a max heap of size k and popping n-k elements will return the kth smallest element
		pq = []
		queue = deque()
		queue.append(root)
		heapq.heappush(pq, -root.val)
		while len(queue) > 0:
			temp = queue.popleft()
			if temp.left != None:
				queue.append(temp.left)
				heapq.heappush(pq, -temp.left.val)
			if temp.right != None:
				queue.append(temp.right)
				heapq.heappush(pq, -temp.right.val)
			while len(pq) > k:
				heapq.heappop(pq)
		return -1 * heapq.heappop(pq)

	count = 0
	res = None
	def kthSmallest(self, root: TreeNode, k: int) -> int:
		# Time Complexity : O(n) because we are traversing each and every element in the tree
		# Space Complexity : Constant ignoring the recursive stack that is used for recursion
		def inorder(root, k):
			if root == None:
				return
			inorder(root.left, k)
			self.count += 1
			if self.count == k:
				self.res = root.val
			inorder(root.right, k)
		inorder(root, k)
		return self.res	

	count = 0
	res = None
	flag = False
	def kthSmallest(self, root: TreeNode, k: int) -> int:
		# Time Complexity : O(k) because we are traversing only the first k elements in inorder traversal
		# Space Complexity : Constant ignoring the recursive stack that is used for recursion
		def inorder(root, k):
			if root == None:
				return
			if not self.flag:
				inorder(root.left, k)
				self.count += 1
				if self.count == k:
					self.res = root.val
					self.flag = True
				inorder(root.right, k)
		inorder(root, k)
		return self.res

	count = 0
	res = None
	flag = False
	def kthSmallest(self, root: TreeNode, k: int) -> int:
		# Time Complexity : O(k) because we are traversing only the first k elements in inorder traversal
		# Space Complexity : Constant ignoring the recursive stack that is used for recursion
		def inorder(root, k):
			if root == None or self.flag:
				return
			inorder(root.left, k)
			self.count += 1
			if self.count == k:
				self.res = root.val
				self.flag = True
			inorder(root.right, k)
		inorder(root, k)