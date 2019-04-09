/* 
	ArraySets 
		Implementation of data structure Set by using array
		Data structure that stores values without any particular order and with no repeated values
*/

var Sets = function(){
	
	// Collection of var as an arryay that will hold the set 
	var collection = [];
	
	/** 
		Sub-method that will check for the presence of an element and return a boolean value 
		@param element The given value to be searched within the set
	*/
	this.has = function(element){
		return (collection.indexOf(element) !== -1);	// indexOf(element) returns the index of array content with value 'element', -1 of the element not found  
	};
	
	/** Sub-method that return all the values stored in the set */
	this.values = function(){
		return collection;
	};
	
	/** 
	*	Sub-method that add a new element to the set 
	*	@param element	The value of the a new element to the set
	*/
	this.add = function(element){
		
		// Validate if the element is new to the set 
		if(!this.has(element)){
			// insert the specific element to the end of set (array)
			collection.push(element);	
			return true;
		}
		return false;
	};
	
	/** 
	*	Sub-method that remove the given element from this element 
	*	@param element The value of target element to be removed from the list
	*/
	this.remove = function(element){
		
		if(this.has(element)){
			index = collection.indexOf(element);	// save the array index of the target element
			
			// 1 element removed
			collection.splice(index,1);				
			return true;
		}
		return false;
	};
	
	/** 
	*	Sub-method that return the size of the collection 
	*/
	this.size = function(){
		return collection.length;
	};
	
	/**
	*	Sub-method that return the union of 2 different sets (A U B)
	*	@param otherSet	The other set 
	*	@return new set that contains the union of those 2 sets
	*/
	this.union = function(otherSet){
		
		var unionSet = new Sets();			// new Set that used to save the union of 2 sets
		var firstSet = this.values();		// this set
		var secondSet = otherSet.values();	// given different set
		
		// Adding every element to the unionSet
		firstSet.forEach(function(e){
			unionSet.add(e);
		});
		
		secondSet.forEach(function(e){
			if(!unionSet.has(e)){
				unionSet.add(e);
			}				
		});
		return unionSet;
	};
	
	/**
	*	Sub-method that return the intersection of 2 different sets (A n B)
	*	@param otherSet Set B
	*	@return new set that contains the intersection of those 2 sets
	*/
	this.intersection = function(otherSet){
		
		var intersectionSet = new Sets();
		var firstSet = this.values();
		firstSet.forEach(function(e){
			if(otherSet.has(e)){
				intersectionSet.add(e);
			}
		});
		return intersectionSet;
	}
	
	/**
	*	Sub-method that return the difference of 2 different sets (A \ B)
	*	@param otherSet	Set B
	*	@return new set that contains the difference of those 2 sets
	*/
	this.difference = function(otherSet){
		
		var differenceSet = new Sets();
		var firstSet = this.values();
		
		firstSet.forEach(function(e){
			if(!otherSet.has(e))
				differenceSet.add(e);
		});
		return differenceSet;
	}
	
	/**
	*	Sub-method that test if this set is a subset of a different set
	*/
	this.subset = function(otherSet){
		var firstSet = this.values();
		
		return firstSet.every(function(value){
			return otherSet.has(value);
		});
	};
}

// ----- Test Case : Self-defined Set DS [Sets()] -----
	var setA = new Sets();  
	var setB = new Sets();  
	
	setA.add("a");  
	setB.add("b");  
	setB.add("c");  
	setB.add("a");  
	setB.add("d");  
	console.log(setA.subset(setB));					// true
	console.log(setA.intersection(setB).values()); 	// ['a']
	console.log(setB.difference(setA).values());	// ['b','c','d']
	
	console.log();
	
	setA.add("e");
	setB.remove("a");
	
	console.log("After modification : ");
	console.log(setA.subset(setB));					// false
	console.log(setA.intersection(setB).values());	// []
	console.log(setA.difference(setB).values());	// ['a','e']
	
	console.log();
	
// ----- Test Case : Library DS [Set()] -----
	var setC = new Set();  
	var setD = new Set();  
	
	setC.add("a");  
	setD.add("b");  
	setD.add("c");  
	setD.add("a");  
	setD.add("d");  
	
	console.log(setD.values());		// ['b','c','a','d']
	
	setD.delete("a");			
	console.log(setD.has("a"));		// false
	console.log(setD.add("d"));		// {'b','c','d'}
