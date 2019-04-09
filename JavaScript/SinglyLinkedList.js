/** Implementation of Data Structure LinkedList in JS (Singly Linked List) 
*	Time Complexity 
*	Algorithm		Average		Worst Case
*	Space			O(n)		O(n)
*	Search			O(n)		O(n)
*	Insert			O(1)		O(1)
*	Delete			O(1)		O(1)
*
*	Advantages :
*		Dynamic size, efficient insertions and deletions, and no waste of memory
*
*	Disadvantage :
*		No random access, sequential access is slow [NOT contiguous saved in memory]
*/

function SinglyLinkedList(){

    /** The private integer variable to indicate the size of the linked list */
    var length = 0;

    /** Special node reference : the head node of the linked list */
	var head = null;

    /**
     * Definition of a Node unit
     * @param {any} element The associate value of the new node
     */
    var Node = function (element) {

        this.element = element;
        this.next = null;
    };

    /**
     * The sub-function to view the size / the total number of nodes in the linked list
     * @return The size / the total number of nodes in the linked list
     */
    this.size = function () {
        return length;
    };

    /**
     * Boolean sub-function that shows if the linked list is empty
     */
    this.isEmpty = function () {
        return length === 0;
    };

    /**
     * The sub-function to add a new node to the linked list with given element value
     * @param {any} element The new value added to the linked list as a new node
     */
    this.add = function (element) {

        // New node to be inserted to the list with given new value
        var node = new Node(element);

        if (head === null)
            head = node;
        else {
            var currentNode = head;

            // Traverse through the list
            while (currentNode.next) {
                currentNode = currentNode.next;
            }

            currentNode.next = node;
        }
        length++;
    };

    /**
     * The sub-function that used to remove specific node from the list
     * @param {any} element The associate value of target node
     */
    this.remove = function (element) {

        var currentNode = head;
        var previousNode;

        if (currentNode.element === element) {
            head = currentNode.next;
        } else {
            while (currentNode.element !== element) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            previousNode.next = currentNode.next;
        }
        length--;
    };

    /**
     * The sub-function that returns the list index of node with element value
     * @param {any} element The associate value of specific node
     */
    this.indexOf = function (element) {

        /** The node reference of current node */
        var currentNode = head;
        /** The index of node in the linked list */
        var index = -1;

        while (currentNode) {
            index++;
            if (currentNode.element === element)
                return index;

            currentNode = currentNode.next;
        }

        return -1;  // This indicates the node with given element value doesn't exist
    };

    /**
     * The sub-function that find the specific node according to the given node index
     * @param {any} index   The given node index number in the linked list
     */
    this.elementAt = function (index) {

        var currentNode = head;
        var count = 0;

        if (index > this.size()) {
            console.log("Error : Element in index " + index + " not found");
            return null;
        }

        while (count < index) {
            count++;
            currentNode = currentNode.next;
        }
        return currentNode.element;
    };

    /**
     * The sub-function that add a new node with specific element value at specific list index
     * @param {any} index   The given node index that the new node will place at
     * @param {any} element The associate value of new node
     */
    this.addAt = function (index, element) {
        var node = new Node(element);

        var currentNode = head;
        var previousNode;
        var currentIndex = 0;

        if (index < 0 || index > length) // The given node number hasn't been used / declared
            return false;

        if (index === 0) {
            node.next = currentNode;
            head = node;
        } else {
            while (currentIndex < index) {
                previousNode = currentNode;
                currentNode = currentNode.next;
				currentIndex++;
            }
            node.next = currentNode;
            previousNode.next = node;
        }
        length++;
    }

    /**
    * The sub-function that remove the node that located at specific given index
    * @param {any} index   The given node index that the removal does at
    */
    this.removeAt = function (index) {

        if (index < 0 || index >= length)
            return null;
        if (index === 0)
            head = currentNode.next;
        else {
			var currentNode = head;
			var previousNode;
			var currentIndex = 0;
            
			while (currentIndex < index) {
                previousNode = currentNode;
                currentNode = currentNode.next;
				currentIndex++;
             }
            previousNode.next = currentNode.next;
        }
        length--;
        return currentNode.element; // The element value on that memory allocation remains
    }

    /**
     * Sub-function to output the whole contents in the LinkedList
     */
    this.list = function () {

        var currentNode = head;
        var currentIndex = 0;

        console.log(this.size());
        while (currentIndex < this.size()) {
            console.log(currentNode.element);
            currentNode = currentNode.next;
            currentIndex++;
        }
    }
}

// Above are function (LinkedList in JS here seems as a main function with sub-function) declaration 
// ----- Test Case -----
var conga = new SinglyLinkedList();
console.log(conga.isEmpty());
conga.add('Kitten');
conga.add('Puppy');
conga.add('Dog');
conga.add('Cat');
conga.add('Fish');
console.log(conga.size());
console.log(conga.removeAt(3));
console.log(conga.elementAt(3));
console.log(conga.indexOf('Puppy'));
console.log(conga.size());
conga.list();
		
