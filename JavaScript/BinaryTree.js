/* Binary Tree / Binary Search Tree 
	Tree is a data structure that composed of nodes,that has the following characteristics :
	1. Root node : The top node in the tree
	2. Root node and their child nodes have 0 or more child nodes
	
	Binary Tree has 2 more characteristics :
	a. Each node has up to two child nodes
	b. For each node, their right-subtree node is always equal or larger, while the left-subtree node is always equal or lower, in order to use the principle of binary search to skip a half of the tree
	
	It allows fast lookup, addition and removal of items / nodes :
	-> Each comparison of nodes (in the same hierarchy) allows the operations to skip about half of the tree
	-> Thus, for each lookup, insertion or deletion takes time proportional to the logarithm of the number of items stored in the tree
	
	Time Complexity of a BST (Binary Search Tree)
	Algorithm		Average			Worst Case 
	Space			O(n)			O(n)
	Search			O(log n)		O(n)
	Insert			O(log n)		O(n)
	Delete			O(log n)		O(n)
	
*/

/**
* Definition of the node class in Tree
*/
class Node {
	
	constructor(data, left = null, right = null){
		this.data = data;	// data storing
		this.left = left;	// reference points to the left child-node
		this.right = right;	// reference points to the right child-node
	}
}

class BST {
	
	/* Class constructor to create a reference to the top/root node on the new tree */
	constructor(){ this.root = null; }
	
	add(data){
		
		const node = this.root;
		
		// Case if the tree is empty
		if(node === null){
			
			this.root = new Node(data);
			return;
			
		} else {
			
			/* Definition of binary searching function here to find the empty space to store the new Tree Node */
			const searchTree = function(node){
				
				if(data < node.data){
					if(node.left === null){
						node.left = new Node(data);
						return;
					}else if(node.left !== null)
						return searchTree(node.left);
				}else if(data > node.data){
					if(node.right === null){
						node.right = new Node(data);
						return;
					}else if(node.right !== null)
						return searchTree(node.right);
				}else
					return null;
			};
			
			return searchTree(node);
		}
	}
	
	remove(data){
		
	}
}