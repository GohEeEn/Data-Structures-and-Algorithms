/* Hash Table [Library built-in available]
	A map data structure that contains key / value pairs, that use a hash function to compute an index into an array of buckets or slots, from which the desired value can be found
	[ As array in JS has no length limit, thus it can be used like ArrayList here with customized array index, otherwise it is advised to implement with LinkedList ]
	- Hash Function : 
		[IN]  String [Key here is a string]
		[OUT] Unique number (Key) , unless same input
		Collision : The same hash value received even with different string given
	- Storing :
		[Key] Hash Value, [Content] String 
	
	Time Complexity : [O(1) -> O(n), depends on the numbers of the same collision]
	Algorithm		Average		Worst Case
	Space			O(n)		O(n)
	Search 			O(1)		O(n)
	Insert			O(1)		O(n)
	Delete			O(1)		O(n)
	
	storage[Hash Value][Collision Entry][0|1] : 0 -> Actual Key , 1 -> Associate value 
*/

/**
*	Hash Function to generate a unique hash value for each different string / data, O(1)
*	@param string	The input value 
*	@param max 		Key value 
*/
var hash = (string, max) => {
	
	var hash = 0;
	for(var i = 0 ; i < string.length ; i++){
		hash += string.charCodeAt(i);
	}
	return hash % max;
};

/**
*	Definition of a Hash Table
*/
let HashTable = function(){
	
	/** Array as the data storage of hash table, 
	*	Array Index : Unique Hash Value [ Encrypted key ]
	*	Array Content : [ key, value ], actual key value and associate value  
	*/
	let storage = [];			
	const storageLimit = 14;	// Number of buckets in this hash table, the lower of this value the higher chance to get collision case
	
	/**
	*	Sub-function to print out the contents in the entire table
	*	<empty item> : Empty bucket that didn't been used 
	*	[[]]	: A bucket (share the same hash value)
	*	[] * N	: N numbers of collision case 
	*/
	this.print = function(){
		console.log(storage);
	};
	
	/**
	*	Sub-function that add a new entry to the hash table
	*	@param	key		The key value 
	*	@param	value 	The associate value of the entry
	*/
	this.add = function(key,value){
		
		var index = hash(key, storageLimit);	// Generate a hash value that refers to the new entry
		
		// If the generated hash is new to the table, assign to the data storage
		if(storage[index] === undefined){
			storage[index] = [[key,value]];
		}else{
			// Case that this hash value has been used ( collision / same value given )
			
			var inserted = false;
			
			// Run through the sub-array that store entries with the same hash value to look for the same content
			for(var i = 0 ; i < storage[index].length ; i++){
					
				if(storage[index][i][0] === key){ // Case if the same content found 
					storage[index][i][1] = value; // Overwrite its associate value 
					inserted = true;
				}
			}
			if(inserted === false){	// Collision Case : Insert to the sub-array as a new entry with same hash
				storage[index].push([key,value]);
			}
		}
	};
	
	/**
	*	Sub-method that remove the entry with given key from the table
	*	@param 	key 	The given actual key value 
	*/
	this.remove = function(key){
		
		var index = hash(key,storageLimit);
		
		// Case that the hash entry with no collision happen
		if(storage[index].length === 1 && storage[index][0][0] === key){
			delete storage[index];
		}else{
			// Find the collision entry with same key 
			for(var i = 0; i < storage[index].length ; i++){
				if(storage[index][i][0] === key)	// Collision entry found 
					delete storage[index][i];
			}
		}
	};
	
	/**
	*	Sub-method that look up the entry with given key
	*	@param 	key 	The given actual key value 
	*/
	this.lookup = function(key){
		var index = hash(key, storageLimit);	// generate the same hash value to find the specific entry
		
		if(storage[index] === undefined){
			return undefined;	// Hash value NOT FOUND : entry not exist
		}else{
			for(var i = 0 ; i < storage[index].length; i++){
				if(storage[index][i][0] === key){
					return storage[index][i][1];
				}
			}
		}
	};
};

	// ----- Test Case ------
	console.log(hash('quincy', 10))

	let ht = new HashTable();
	ht.add('beau', 'person');
	ht.add('fido', 'dog');
	ht.add('rex', 'dinosour');
	ht.add('tux', 'penguin')
	console.log(ht.lookup('rex'))
	ht.print();
	ht.add('rex', 'T-rex');
	ht.remove('tux');
	console.log("\nAfter modification :");
	console.log(ht.lookup('rex'))
	ht.print();