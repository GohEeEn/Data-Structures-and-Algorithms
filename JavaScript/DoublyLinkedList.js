/* DoublyLinkedList */

// Definition of Node class in DoublyLinkedList
var Node = function(data, prev) {
  this.data = data;
  this.prev = prev;
  this.next = null;
};

// Definition and sub-function of DoublyLinkedList
var DoublyLinkedList = function() {
	
  var head = null;
  var tail = null;
  var length = 0;

  this.size = function(){return length;};
  
  this.isEmpty = function(){ return length === 0; };

  // change code below this line
  this.add = function(element){

    var newNode = new Node(element, null);
	
    if(length === 0){
      head = newNode;
      tail = newNode;
    }
    else{
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }
  
  // remove(element) method here will remove all the occurrences of a given element in the list
  this.remove = function(element){
    
    if(length === 0)
      return null;
    else{
      
      if(head.data === element){
        head = head.next;
        head.prev = null;
      }

      if(tail.data === element){
        tail = tail.prev;
        tail.next = null;
      }

      var prev = null;
      var curr = head;

      while(curr.next != null){
        
        if(curr.data === element){
          prev.next = curr.next;
          curr.next.prev = prev;
          length--;
        }
        prev = prev.next;
        curr = curr.next;
      }
    }
  }
  // change code above this line
  
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
            if (currentNode.data === element)
                return index;

            currentNode = currentNode.next;
        }

        return -1;  // This indicates the node with given element value doesn't exist
    };

    /**
     * The sub-function that find the specific node according to the given node index
     * @param {any} index   The given node index number in the linked list
     */
    this.dataAt = function (index) {

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
        return currentNode.data;
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
        return currentNode.data; // The element value on that memory allocation remains
    }
	
	/**
     * Sub-function to output the whole contents in the LinkedList
     */
    this.list = function () {

        var currentNode = head;
        var currentIndex = 0;

        console.log(this.size());
        while (currentIndex < this.size()) {
            console.log(currentNode.data);
            currentNode = currentNode.next;
            currentIndex++;
        }
    }
};

// ----- Test Case -----
var conga = new DoublyLinkedList();
console.log(conga.size());
conga.add('Kitten');
conga.add('Puppy');
conga.add('Dog');
conga.add('Cat');
conga.add('Fish');
console.log(conga.removeAt(3));
console.log(conga.dataAt(3));
console.log(conga.indexOf('Puppy'));
console.log(conga.size());
conga.list();
		