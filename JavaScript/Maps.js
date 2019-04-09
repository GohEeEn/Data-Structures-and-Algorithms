/* Maps 
	Data structure that stores data in key / value pairs where every key is unique
	Sometime it is called an associative array or dictionary, that often used for fast look-ups of data 
	
	Both key and value can be any type of variables
	Here it is implemneted by using JS array [ Array Index in JS are no need to be integer ] 
*/

	let Maps = function(){
		
		this.collection = {};
		this.count = 0;
		
		/**
		*	Sub-method to return the size of map ( total number of entries )
		*/
		this.size = function(){
			return this.count;
		};
		
		/**
		*	Sub-method that create a new entry to the map
		*	@param	key		The key value of the entry
		*	@param	value	The associative value of the entry
		*/
		this.set = function(key,value){
			
			this.collection[key] = value; // Array index in JS can be any data type
			this.count++;
		};
			
		/**
		*	Sub-method that check if the entry with given key exists
		*	@param	key		The given key value 
		*/
		this.has = function(key){
			return (key in this.collection);
		};
		
		/**
		*	Sub-method that return the associated value of the entry with the given key, else return null
		*	@param	key		The given key value 
		*	@return	the associated value of the entry, else null
		*/
		this.get = function(key){
			return (key in this.collection) ? this.collection[key] : null ;
		};
		
		/**
		*	Sub-method that remove entry that has the given key
		*	@param	key		The given key value 
		*/
		this.remove = function(key){
			
			// If the array index that has the given key is found
			if(key in this.collection){
				delete this.collection[key];	// remove it from the array
				this.count--;
			}
		};
		
		/**
		*	Sub-method that return the associated value in the entire map
		*/
		this.values = function(){
			let result = new Array();	// declare a new array that save the values of the entire map
			
			// Assign the value of the entire map to the new array (Default index by using integer)
			for(let key of Object.keys(this.collection)){
				result.push(this.collection[key]);
			}
			
			return (result.length  > 0) ? result : null;
		};
		
		/**
		*	Sub-method that return the key value in the entire map
		*/
		this.keys = function(){
			let result = new Array();
			
			// Loop through the array by using Object.keys	
			// for( ForDeclaration of AssignmentExpression ) {statement}
			for(let key of Object.keys(this.collection)){
				result.push(key);
			}
			
			return (result.length > 0) ? result : null;
		};
		
		/** Sub-method that return all the entries in the entire map */
		this.entries = function(){ return this.collection; };
		
		/**
		*	Sub-method that reset the whole map into an empty map
		*/
		this.clear = function(){
			this.collection = {};
			this.count = 0;
		};
	}
	
	// ----- Test Case ------
	
	let map = new Maps();
	map.set('arms', 2);
	map.set('fingers', 10);
	map.set('eyes', 2);
	map.set('belley button', 1);

	console.log(map.get('fingers'));
	console.log(map.size());
	console.log(map.values());
	console.log(map.keys());
	console.log(map.entries());
	console.log();

	// ----- Test Case : Library DS -----
	
	let map2 = new Map();
	
	// Empty Map
	console.log(map2.has('hands'));
	console.log(map2.entries());

	let keyObj = {},
    keyFunc = function() {};
	
	// It shows any type of variables can be the array index 
	map2.set('hello', 'string value');
	map2.set(keyObj, 'obj value');
	map2.set(keyFunc, 'func value');
	map2.set(NaN, 'NaN value')

	console.log(map2.size);
	
	// Access the map by using their keys 
	console.log(map2.get('hello'));
	console.log(map2.get(keyObj));
	console.log(map2.get(keyFunc));
	console.log(map2.get(NaN));