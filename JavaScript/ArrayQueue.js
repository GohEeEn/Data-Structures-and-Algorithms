/* Queues 
	Implement by using Array
	Time complexity :
	Algorithm		Average		Worst Case
	Space			O(n)		O(n)
	Search			O(n)		O(n)
	Insert			O(1)		O(1)
	Delete			O(1)		O(1)
*/ 

function ArrayQueue(){
	
	// Array
	collection = [];
	
	// Sub-function to display the content of the whole queue
	this.print = function(){
		console.log(collection);
	};
	
	/**
		Enqueue : Add a new element to the end of queue
	*/
	this.enqueue = function(element){
		collection.push(element);	// Array.push() add a new element to the end of array
	};
	
	/**
		Dequeue : Remove the first element from the head of queue
	*/
	this.dequeue = function(){
		return collection.shift();
	};
	
	/**
		Reference to the first element in the queue
	*/
	this.front = function(){
		return collection[0];
	};
	
	this.size = function(){
		return collection.length;
	};
	
	this.isEmpty = function(){
		return (collection.length === 0);
	};
}

// ----- Test Case ------
var q = new ArrayQueue();
console.log(q.isEmpty());
q.enqueue('a');
q.enqueue('b');
q.enqueue('c');
q.print();
q.dequeue();
console.log(q.front());
q.print();