/* Priority Queue 
	Queue-like data structure while the insertion of elements depend on the rules defined
	Example here, the priority of elements depends on the queue number given, eg. ['Ee En Goh',6], qn = 6
*/

var PriorityQueue = function(){
	
	var collection = [];	// Declare an array in JS
	
	/** Sub-function to display the whole queue */
	this.printCollection = function(){
		console.log("Current Queue : ");
		console.log(collection);
	};
	
	/** Enqueue : Insertion of element to the rear of queue */
	this.enqueue = function(element){
		
		if(this.isEmpty()){
			collection.push(element);
		}else{
			
			var added = false;
			
			for(var i = 0 ; i < collection.length ; i++){
				
				// Checking Priorities : Rules defined according to the queue number given
				if(element[1] < collection[i][1]){ 
					collection.splice(i,0,element);
					added = true;
					break;
				}
			}
			if(!added){
				collection.push(element);
			}
		}
	};
	
	/** Dequeue : Deletion of element from the front of queue */
	this.dequeue = function(){
		var al = collection.shift();
		return al[0]; // return removed value 
	};
	
	/** Return the first element of the queue */
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

// ----- Test Case -----
var pq = new PriorityQueue(); 
pq.enqueue(['Beau Carnes', 2]); 
pq.enqueue(['Quincy Larson', 3]);
pq.enqueue(['Ewa Mitulska-Wójcik', 1])
pq.enqueue(['Briana Swift', 2])
pq.printCollection();
pq.dequeue();
console.log();
console.log("After dequeue, front element :");
console.log(pq.front());
console.log();
pq.printCollection();