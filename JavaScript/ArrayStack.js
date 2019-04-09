/* 
	Stack 
	Three main operations :
	Insertion : push()
	Deletion  : pop()
	Display	  : peek()
	
	Time Complexity :
	Algorithm		Average		Worst Case
	Space			O(n)		O(n)
	Search			O(n)		O(n)
	Insert			O(1)		O(1)
	Delete			O(1)		O(1)
*/
var ArrayStack = function(){
	
	this.count = 0;
	// this.top = null;
	this.storage = {};
	
	this.size = function() { return this.count; }
	this.isEmpty = function(){ return count === 0; }
	
	// Adding a value onto the top of the stack
	this.push = function(value){
		
		this.storage[this.count] = value;
		this.count++;
	}
	
	// Removes and returns the value at the end of the stack
	this.pop = function(){
		if(this.count === 0){
			return undefined;
		}
		this.count--;
		var result = this.storage[this.count];
		delete this.storage[this.count];
		return result;
	}
	
	// Returns the value at the end of the stack
	this.peek = function(){ return this.storage[this.count-1];}
	this.clear = function(){ this.storage = null; }
	
	this.print = function(){ 
		console.log(storage); 
	}
	
}

	// ----- Test Case : Palindrone Checker by using Stack -----
	
	var letters = new ArrayStack(); // this is our stack
	var word = "Abanaba";
	var word1 = word.toLowerCase();
	var rword = ""; // reverse word

	// put letters of word into stack
	for (var i = 0; i < word.length; i++) {
		letters.push(word1[i]);
		// console.log(letters.peek());
	}

	// pop off the stack in reverse order to form a full string
	for (var i = 0; i < word.length; i++) {
		rword += letters.pop(); 
	}
	
	// Case to check if the string is a palindrone
	if(rword === word1){
		console.log(word + " is a palindrome.");
	}
	else{
		console.log(word + " is not a palindrome.");
}